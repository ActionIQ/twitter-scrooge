package com.twitter.scrooge

import com.twitter.scrooge.AST._
import org.apache.thrift.protocol.TProtocol

trait ThriftStruct {
  def write(oprot: TProtocol)
}

object ScalaGenerator {

  val header =
"""/**
 * Autogenerated by Scrooge
 * Edit this shit, I dare you.
 */

package {{scalaNamespace}}

import scala.collection._
"""

  val enumTemplateText =
header + """import org.apache.thrift.TEnum

object {{name}} {
{{values.map { v => "case object " + v.name + " extends " + name + "(" + v.value + ")"}.indent}}

  def apply(value: Int): Option[{{name}}] = {
    value match {
{{values.map { v => "case " + v.value + " => Some(" + v.name + ")"}.indent(3)}}
      case _ => None
    }
  }
}

abstract class {{name}}(val value: Int) {
  def toThrift = new TEnum {
    override def getValue = {
      value
    }
  }
}"""

  val constsTemplateText =
header + """object Constants {
{{constList.map { e => constTemplate(e, scope) }.indent}}
}
"""

  val constTemplateText = "val {{name}}: {{scalaType(`type`)}} = {{constantTemplate(`type`, value)}}"

  val basicReadFieldTemplateText =
"""case {{id.toString}} => { /* {{name}} */
  field.`type` match {
    case TType.{{constType(`type`)}} => {{name}} = iprot.{{protocolReadMethod(`type`)}}
    case _ => TProtocolUtil.skip(iprot, field.`type`)
  }
}"""

  val listReadFieldTemplateText =
"""case {{id.toString}} => { /* {{name}} */
  field.`type` match {
    case TType.{{constType(`type`)}} => {
      val _list = iprot.readListBegin()
      val _{{name}} = new mutable.ListBuffer[{{scalaType(`type`.asInstanceOf[AST.ListType].tpe)}}]
      var _i = 0
      while(_i < _list.size) {
        _{{name}} += iprot.{{protocolReadMethod(`type`.asInstanceOf[AST.ListType].tpe)}}
        _i += 1
      }
      iprot.readListEnd()
      {{name}} = _{{name}}.toList
    }
    case _ => TProtocolUtil.skip(iprot, field.`type`)
  }
}
"""

  val structReadFieldTemplateText =
"""case {{id.toString}} => {/* {{name}} */
  field.`type` match {
    case TType.{{constType(`type`)}} => {
      {{name}} = {{`type`.asInstanceOf[AST.ReferenceType].name}}.decoder(iprot)
    }
    case _ => TProtocolUtil.skip(iprot, field.`type`)
  }
}
 """

  val basicWriteFieldTemplateText =
"""oprot.writeFieldBegin({{writeFieldConst(name)}})
oprot.{{protocolWriteMethod(`type`)}}({{name}})
oprot.writeFieldEnd()"""

  val stringWriteFieldTemplateText =
"""if ({{name}} != null) {
  oprot.writeFieldBegin({{writeFieldConst(name)}})
  oprot.writeString({{name}})
  oprot.writeFieldEnd()
}"""

  val listWriteFieldTemplateText =
"""if ({{name}} != null) {
  oprot.writeListBegin(new TList(TType.{{constType(`type`.asInstanceOf[AST.ListType].tpe)}}, {{name}}.size))
  {{name}}.foreach { oprot.{{protocolWriteMethod(`type`.asInstanceOf[AST.ListType].tpe)}}(_) }
  oprot.writeFieldEnd()
}"""

  val structWriteFieldTemplateText =
"""if ({{name}} != null) {
  oprot.writeFieldBegin({{writeFieldConst(name)}})
  {{name}}.write(oprot)
  oprot.writeFieldEnd()
}"""

  val structTemplateText =
header + """import org.apache.thrift.protocol._
import com.twitter.scrooge.ThriftStruct

object {{name}} {
  object decoder extends (TProtocol => ThriftStruct) {
    override def apply(iprot: TProtocol) = {
      var field: TField = null
{{fields.map { f => "var " + f.name + defaultValueTemplate(f) }.indent(3)}}
      var done = false
      iprot.readStructBegin()
      while (!done) {
        field = iprot.readFieldBegin
        if (field.`type` == TType.STOP) {
          done = true
        } else {
          field.id match {
{{fields.map { f => structReadFieldTemplate(f)(f, scope) }.indent(6) }}
            case _ => TProtocolUtil.skip(iprot, field.`type`)
          }
          iprot.readFieldEnd()
        }
      }
      iprot.readStructEnd()
      new {{name}}({{fields.map { f => f.name }.mkString(", ")}})
    }
  }
}

case class {{name}}({{fields.map { f => f.name + ": " + scalaType(f.`type`) }.mkString(", ")}}) extends ThriftStruct {
  private val STRUCT_DESC = new TStruct("{{name}}")
{{fields.map { f => "private val " + writeFieldConst(f.name) + " = new TField(\"" + f.name + "\", TType." + constType(f.`type`) + ", " + f.id.toString + ")"}.indent}}

  override def write(oprot: TProtocol) {
    validate()

    oprot.writeStructBegin(STRUCT_DESC)
{{fields.map { f => structWriteFieldTemplate(f)(f, scope) }.indent(2) }}
    oprot.writeFieldStop()
    oprot.writeStructEnd()
  }

  def validate() = true //TODO: Implement this
}"""

  case class ScalaService(scalaNamespace: String, javaNamespace: String, service: Service)
  case class ConstList(constList: Array[Const])
}

// maybe should eventually go elsewhere.
class ScalaGenerator {
  import ScalaGenerator._

  var scalaNamespace: String = null
  var javaNamespace: String = null

  val enumTemplate = Template[Enum](enumTemplateText)
  val constsTemplate = Template[ConstList](constsTemplateText)
  val constTemplate = Template[Const](constTemplateText)
  val structTemplate = Template[Struct](structTemplateText)

  // Constants
  val stringTemplate = Template[StringConstant](""""{{value}}"""")
  val doubleTemplate = Template[DoubleConstant]("{{value.toString}}")
  val intTemplate = Template[IntConstant]("{{value.toString}}")
  val listTemplate = Template[ListConstant](
    """List({{elems.map { e => constantTemplate(null, e) }.mkString(", ")}})"""
  )
  val mapTemplate =  Template[MapConstant](
    """Map({{elems.asInstanceOf[Map[com.twitter.scrooge.AST.Constant, com.twitter.scrooge.AST.Constant]].map { case (x, y) => constantTemplate(null, x) + " -> " + constantTemplate(null, y) }.mkString(",\n")}})"""
  )

  def constantTemplate(`type`: FieldType, constant: Constant): String = {
    constant match {
      case c @ StringConstant(_) =>
        stringTemplate(c, this)
      case c @ DoubleConstant(_) =>
        doubleTemplate(c, this)
      case c @ IntConstant(_) =>
        intTemplate(c, this)
      case c @ ListConstant(_) =>
        listTemplate(c, this)
      case c @ MapConstant(_) =>
        mapTemplate(c, this)
      case c @ Identifier(name) =>
        `type`.asInstanceOf[ReferenceType].name + "." + name
    }
  }

  def writeFieldConst(name: String) = name.toUpperCase + "_FIELD_DESC"

  def structWriteFieldTemplate(field: Field) = {
    field.`type` match {
      case TString => Template[Field](stringWriteFieldTemplateText)
      case list: ListType => Template[Field](listWriteFieldTemplateText)
      case r: ReferenceType => Template[Field](structWriteFieldTemplateText)
      case _ => Template[Field](basicWriteFieldTemplateText)
    }
  }
  def structReadFieldTemplate(field: Field) = {
    field.`type` match {
      case l: ListType => Template[Field](listReadFieldTemplateText)
      case r: ReferenceType => Template[Field](structReadFieldTemplateText)
      case _ => Template[Field](basicReadFieldTemplateText)
    }
  }

  def defaultValueTemplate(field: Field) = {
    field.`type` match {
      case c @ TI16 => {
        ": " + scalaType(c) + " = 0"
      }
      case c @ TI32 => {
        ": " + scalaType(c) + " = 0"
      }
      case c @ TI64 => {
        ": " + scalaType(c) + " = 0"
      }
      case c @ _ => {
        ": " + scalaType(c) + " = null"
      }
    }
  }

  def constType(t: FunctionType): String = {
    t match {
      case Void => "VOID"
      case TBool => "BOOL"
      case TByte => "BYTE"
      case TDouble => "DOUBLE"
      case TI16 => "I16"
      case TI32 => "I32"
      case TI64 => "I64"
      case TString => "STRING"
      case TBinary => "STRING" // IDK why, but Binary fields are marked as String
      case ReferenceType(_) => "STRUCT" // FIXME could also be Enum
      case MapType(_, _, _) => "MAP"
      case SetType(_, _) => "SET"
      case ListType(_, _) => "LIST"
      case x => "????" + x + "????"
    }
  }

  def protocolReadMethod(t: FunctionType): String = {
    t match {
      case TBool => "readBool"
      case TByte => "readByte"
      case TI16 => "readI16"
      case TI32 => "readI32"
      case TI64 => "readI64"
      case TDouble => "readDouble"
      case TString => "readString"
      case TBinary => "readBinary"
      case x => "????" + x + "????"
    }
  }

  def protocolWriteMethod(t: FunctionType): String = {
    t match {
      case TBool => "writeBool"
      case TByte => "writeByte"
      case TI16 => "writeI16"
      case TI32 => "writeI32"
      case TI64 => "writeI64"
      case TDouble => "writeDouble"
      case TString => "writeString"
      case TBinary => "writeBinary"
      case x => "????" + x + "????"
    }
  }

  def scalaType(t: FunctionType): String = {
    t match {
      case Void => "Void"
      case TBool => "Boolean"
      case TByte => "Byte"
      case TI16 => "Short"
      case TI32 => "Int"
      case TI64 => "Long"
      case TDouble => "Double"
      case TString => "String"
      case TBinary => "ByteBuffer"
      case ReferenceType(x) => x
      case MapType(k, v, _) => "Map[" + scalaType(k) + ", " + scalaType(v) + "]"
      case SetType(x, _) => "Set[" + scalaType(x) + "]"
      case ListType(x, _) => "Seq[" + scalaType(x) + "]"
    }
  }

  def javaType(t: FunctionType): String = {
    t match {
      case Void => "Void"
      case TBool => "java.lang.Boolean"
      case TByte => "java.lang.Byte"
      case TI16 => "java.lang.Short"
      case TI32 => "java.lang.Integer"
      case TI64 => "java.lang.Long"
      case TDouble => "java.lang.Double"
      case TString => "String"
      case TBinary => "ByteBuffer"
      case ReferenceType(x) => x
      case MapType(k, v, _) => "java.util.Map[" + javaType(k) + ", " + javaType(v) + "]"
      case SetType(x, _) => "java.util.Set[" + javaType(x) + "]"
      case ListType(x, _) => "java.util.List[" + javaType(x) + "]"
    }
  }

  def javaize(name: String, t: FunctionType): String = {
    t match {
      case TBool => name + ".booleanValue"
      case TByte => name + ".byteValue"
      case TI16 => name + ".shortValue"
      case TI32 => name + ".intValue"
      case TI64 => name + ".longValue"
      case TDouble => name + ".doubleValue"
      case TString => name
      case TBinary => name
      case ReferenceType(x) => x + ".toThrift"
      case MapType(k, v, _) => "asScalaMap(" + name + ").view.map { case (k, v) => (" + javaize("k", k) + ", " + javaize("v", v) + ") }"
      case SetType(x, _) => "asScalaSet(" + name + ").view.map { x => " + javaize("x", x) + " }"
      case ListType(x, _) => "asScalaBuffer(" + name + ").view.map { x => " + javaize("x", x) + " }"
    }
  }

  def scalaize(name: String, t: FunctionType): String = {
    "FIXME"
  }

  implicit def string2indent(underlying: String) = new Object {
    def indent(level: Int = 1): String = underlying.split("\\n").map { ("  " * level) + _ }.mkString("\n")
    def indent: String = indent(1)
  }
  implicit def seq2indent(underlying: Seq[String]) = new Object {
    def indent(level: Int = 1): String = underlying.mkString("\n").indent(level)
    def indent: String = indent(1)
  }
  implicit def array2indent(underlying: Array[String]) = new Object {
    def indent(level: Int = 1): String = underlying.mkString("\n").indent(level)
    def indent: String = indent(1)
  }

  def apply(enum: Enum): String = enumTemplate(enum, this)
  def apply(consts: ConstList): String = constsTemplate(consts, this)
  def apply(const: Const): String = constTemplate(const, this)
  def apply(struct: Struct): String = structTemplate(struct, this)

  def apply(doc: Document): String = {
    javaNamespace = doc.headers.collect {
      case Namespace("java", x) => x
    }.headOption.getOrElse("thrift")
    scalaNamespace = doc.headers.collect {
      case Namespace("scala", x) => x
    }.headOption.getOrElse(javaNamespace)

    apply(ConstList(doc.defs.collect { case c @ Const(_, _, _) => c }))
    doc.defs.foreach {
      case enum @ Enum(_, _) =>
        apply(enum)
      case Const(_, _, _) => // Already dealt with you
      case _ => // nothing for now.
    }
    ""
  }
}