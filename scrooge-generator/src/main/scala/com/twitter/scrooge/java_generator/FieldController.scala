package com.twitter.scrooge.java_generator

import com.twitter.scrooge.ast.{Field, Identifier, Requiredness}
import com.twitter.scrooge.backend.Generator

class FieldController(f: Field, generator: ApacheJavaGenerator, ns: Option[Identifier])
    extends BaseController(generator, ns) {
  val field_name = f.sid.name
  val requirement = getRequirement(f)
  val default = !f.default.isEmpty
  val optional = f.requiredness.isOptional
  val required = f.requiredness.isRequired
  val constructionRequired = Generator.isConstructionRequiredField(f)

  val field_type = new FieldTypeController(f.fieldType, generator)

  def getRequirement(field: Field) = {
    field.requiredness match {
      case Requiredness.Required => "TFieldRequirementType.REQUIRED"
      case Requiredness.Optional => "TFieldRequirementType.OPTIONAL"
      case _ => "TFieldRequirementType.DEFAULT"
    }
  }

  val i_if_nullable = newHelper { input =>
    if (generator.isNullableType(f.fieldType)) indent(input, 2, false) else input
  }

  val i_if_optional = newHelper { input =>
    if (optional) indent(input, 2, false) else input
  }
}
