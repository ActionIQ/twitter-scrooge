/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.scrooge.{
  HasThriftStructCodec3,
  LazyTProtocol,
  TFieldBlob,
  ThriftException,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ThriftUtil
}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.{TMemoryBuffer, TTransport}
import java.nio.ByteBuffer
import java.util.Arrays
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.collection.mutable.{
  ArrayBuffer => mutable$ArrayBuffer, Buffer => mutable$Buffer,
  HashMap => mutable$HashMap, HashSet => mutable$HashSet}
import scala.collection.{Map, Set}


object AnotherException extends ThriftStructCodec3[AnotherException] {
  private val NoPassthroughFields = immutable$Map.empty[Short, TFieldBlob]
  val Struct = new TStruct("AnotherException")
  val ErrorCodeField = new TField("errorCode", TType.I32, 1)
  val ErrorCodeFieldManifest = implicitly[Manifest[Int]]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      ErrorCodeField,
      false,
      false,
      ErrorCodeFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None
    )
  )

  lazy val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: AnotherException): Unit = {
  }

  def withoutPassthroughFields(original: AnotherException): AnotherException =
    new AnotherException(
      errorCode =
        {
          val field = original.errorCode
          field
        }
    )

  override def encode(_item: AnotherException, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  override def decode(_iprot: TProtocol): AnotherException = {
    var errorCode: Int = 0
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false

    _iprot.readStructBegin()
    while (!_done) {
      val _field = _iprot.readFieldBegin()
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _field.`type` match {
              case TType.I32 =>
                errorCode = readErrorCodeValue(_iprot)
              case _actualType =>
                val _expectedType = TType.I32
                throw new TProtocolException(
                  "Received wrong type for field 'errorCode' (expected=%s, actual=%s).".format(
                    ttypeToString(_expectedType),
                    ttypeToString(_actualType)
                  )
                )
            }
          case _ =>
            if (_passthroughFields == null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += (_field.id -> TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    }
    _iprot.readStructEnd()

    new AnotherException(
      errorCode,
      if (_passthroughFields == null)
        NoPassthroughFields
      else
        _passthroughFields.result()
    )
  }

  def apply(
    errorCode: Int
  ): AnotherException =
    new AnotherException(
      errorCode
    )

  def unapply(_item: AnotherException): _root_.scala.Option[Int] = _root_.scala.Some(_item.errorCode)


  @inline private def readErrorCodeValue(_iprot: TProtocol): Int = {
    _iprot.readI32()
  }

  @inline private def writeErrorCodeField(errorCode_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeFieldBegin(ErrorCodeField)
    writeErrorCodeValue(errorCode_item, _oprot)
    _oprot.writeFieldEnd()
  }

  @inline private def writeErrorCodeValue(errorCode_item: Int, _oprot: TProtocol): Unit = {
    _oprot.writeI32(errorCode_item)
  }


}

class AnotherException(
    val errorCode: Int,
    val _passthroughFields: immutable$Map[Short, TFieldBlob])
  extends ThriftException with com.twitter.finagle.SourcedException with ThriftStruct
  with _root_.scala.Product1[Int]
  with HasThriftStructCodec3[AnotherException]
  with java.io.Serializable
{
  import AnotherException._
  def this(
    errorCode: Int
  ) = this(
    errorCode,
    Map.empty
  )

  def _1 = errorCode


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    lazy val _buff = new TMemoryBuffer(32)
    lazy val _oprot = new TCompactProtocol(_buff)
    _passthroughFields.get(_fieldId) match {
      case blob: _root_.scala.Some[TFieldBlob] => blob
      case _root_.scala.None => {
        val _fieldOpt: _root_.scala.Option[TField] =
          _fieldId match {
            case 1 =>
              if (true) {
                writeErrorCodeValue(errorCode, _oprot)
                _root_.scala.Some(AnotherException.ErrorCodeField)
              } else {
                _root_.scala.None
              }
            case _ => _root_.scala.None
          }
        _fieldOpt match {
          case _root_.scala.Some(_field) =>
            val _data = Arrays.copyOfRange(_buff.getArray, 0, _buff.length)
            _root_.scala.Some(TFieldBlob(_field, _data))
          case _root_.scala.None =>
            _root_.scala.None
        }
      }
    }
  }

  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids flatMap { id => getFieldBlob(id) map { id -> _ } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): AnotherException = {
    var errorCode: Int = this.errorCode
    var _passthroughFields = this._passthroughFields
    _blob.id match {
      case 1 =>
        errorCode = readErrorCodeValue(_blob.read)
      case _ => _passthroughFields += (_blob.id -> _blob)
    }
    new AnotherException(
      errorCode,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): AnotherException = {
    var errorCode: Int = this.errorCode

    _fieldId match {
      case 1 =>
        errorCode = 0
      case _ =>
    }
    new AnotherException(
      errorCode,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetErrorCode: AnotherException = unsetField(1)


  override def write(_oprot: TProtocol): Unit = {
    AnotherException.validate(this)
    _oprot.writeStructBegin(Struct)
    writeErrorCodeField(errorCode, _oprot)
    if (_passthroughFields.nonEmpty) {
      _passthroughFields.values.foreach { _.write(_oprot) }
    }
    _oprot.writeFieldStop()
    _oprot.writeStructEnd()
  }

  def copy(
    errorCode: Int = this.errorCode,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): AnotherException =
    new AnotherException(
      errorCode,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[AnotherException]

  private def _equals(x: AnotherException, y: AnotherException): Boolean =
      x.productArity == y.productArity &&
      x.productIterator.sameElements(y.productIterator)

  override def equals(other: Any): Boolean =
    canEqual(other) &&
      _equals(this, other.asInstanceOf[AnotherException]) &&
      _passthroughFields == other.asInstanceOf[AnotherException]._passthroughFields

  override def hashCode: Int = _root_.scala.runtime.ScalaRunTime._hashCode(this)

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)


  override def productArity: Int = 1

  override def productElement(n: Int): Any = n match {
    case 0 => this.errorCode
    case _ => throw new IndexOutOfBoundsException(n.toString)
  }

  override def productPrefix: String = "AnotherException"

  def _codec: ThriftStructCodec3[AnotherException] = AnotherException
}