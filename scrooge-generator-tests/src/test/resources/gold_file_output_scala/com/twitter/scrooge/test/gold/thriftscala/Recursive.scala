/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 *   source file: scrooge/scrooge-generator-tests/src/test/resources/gold_file_input/gold.thrift
 */
package com.twitter.scrooge.test.gold.thriftscala

import com.twitter.io.Buf
import com.twitter.scrooge.{
  InvalidFieldsException,
  LazyTProtocol,
  StructBuilder,
  StructBuilderFactory,
  TFieldBlob,
  ThriftStruct,
  ThriftStructCodec3,
  ThriftStructField,
  ThriftStructFieldInfo,
  ThriftStructMetaData,
  ValidatingThriftStruct,
  ValidatingThriftStructCodec3
}
import com.twitter.scrooge.adapt.{AccessRecorder, AdaptTProtocol, Decoder}
import org.apache.thrift.protocol._
import org.apache.thrift.transport.TMemoryBuffer
import scala.collection.immutable.{Map => immutable$Map}
import scala.collection.mutable.Builder
import scala.reflect.{ClassTag, classTag}


object Recursive extends ValidatingThriftStructCodec3[Recursive] with StructBuilderFactory[Recursive] {
  val Struct: TStruct = new TStruct("Recursive")
  val IdField: TField = new TField("id", TType.I64, 1)
  val IdFieldManifest: Manifest[Long] = manifest[Long]
  val RecRequestField: TField = new TField("recRequest", TType.STRUCT, 2)
  val RecRequestFieldManifest: Manifest[com.twitter.scrooge.test.gold.thriftscala.Request] = manifest[com.twitter.scrooge.test.gold.thriftscala.Request]

  /**
   * Field information in declaration order.
   */
  lazy val fieldInfos: scala.List[ThriftStructFieldInfo] = scala.List[ThriftStructFieldInfo](
    new ThriftStructFieldInfo(
      IdField,
      false,
      false,
      IdFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None,
      _root_.scala.Option(0)
    ),
    new ThriftStructFieldInfo(
      RecRequestField,
      true,
      false,
      RecRequestFieldManifest,
      _root_.scala.None,
      _root_.scala.None,
      immutable$Map.empty[String, String],
      immutable$Map.empty[String, String],
      None,
      _root_.scala.Option(com.twitter.scrooge.test.gold.thriftscala.Request.unsafeEmpty)
    )
  )


  val structAnnotations: immutable$Map[String, String] =
    immutable$Map.empty[String, String]

  private val fieldTypes: IndexedSeq[ClassTag[_]] = IndexedSeq[ClassTag[_]](
    classTag[Long].asInstanceOf[ClassTag[_]],
    classTag[_root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request]].asInstanceOf[ClassTag[_]]
  )

  private[this] val structFields: Seq[ThriftStructField[Recursive]] = Seq[ThriftStructField[Recursive]](
    new ThriftStructField[Recursive](
      IdField,
      _root_.scala.Some(IdFieldManifest),
      classOf[Recursive]) {
        def getValue[R](struct: Recursive): R = struct.id.asInstanceOf[R]
    },
    new ThriftStructField[Recursive](
      RecRequestField,
      _root_.scala.Some(RecRequestFieldManifest),
      classOf[Recursive]) {
        def getValue[R](struct: Recursive): R = struct.recRequest.asInstanceOf[R]
    }
  )

  override lazy val metaData: ThriftStructMetaData[Recursive] =
    ThriftStructMetaData(this, structFields, fieldInfos, Nil, structAnnotations)

  /**
   * Checks that all required fields are non-null.
   */
  def validate(_item: Recursive): Unit = {
  }

  /**
   * Checks that the struct is a valid as a new instance. If there are any missing required or
   * construction required fields, return a non-empty list.
   */
  def validateNewInstance(item: Recursive): scala.Seq[com.twitter.scrooge.validation.Issue] = {
    val buf = scala.collection.mutable.ListBuffer.empty[com.twitter.scrooge.validation.Issue]

    buf ++= validateField(item.id)
    buf ++= validateField(item.recRequest)
    buf.toList
  }

  /**
   * Validate that all validation annotations on the struct meet the criteria defined in the
   * corresponding [[com.twitter.scrooge.validation.ThriftConstraintValidator]].
   */
  def validateInstanceValue(item: Recursive): Set[com.twitter.scrooge.thrift_validation.ThriftValidationViolation] = {
    val violations = scala.collection.mutable.Set.empty[com.twitter.scrooge.thrift_validation.ThriftValidationViolation]
    violations ++= validateFieldValue("id", item.id, fieldInfos.apply(0).fieldAnnotations, scala.None)
    violations ++= validateFieldValue("recRequest", item.recRequest, fieldInfos.apply(1).fieldAnnotations, scala.None)
    violations.toSet
  }

  def withoutPassthroughFields(original: Recursive): Recursive =
    new Immutable(
      id = original.id,
      recRequest =
        {
          val field = original.recRequest
          field.map { field =>
            com.twitter.scrooge.test.gold.thriftscala.Request.withoutPassthroughFields(field)
          }
        }
    )

  lazy val unsafeEmpty: Recursive = {
    val id: Long = 0
    val recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = _root_.scala.None

    new Immutable(
      id,
      recRequest,
      _root_.com.twitter.scrooge.internal.TProtocols.NoPassthroughFields
    )
  }

  def newBuilder(): StructBuilder[Recursive] = new RecursiveStructBuilder(_root_.scala.None, fieldTypes)

  override def encode(_item: Recursive, _oproto: TProtocol): Unit = {
    _item.write(_oproto)
  }

  @volatile private[this] var adaptiveDecoder: Decoder[Recursive] = _

  private[this] val accessRecordingDecoderBuilder: AccessRecorder => Decoder[Recursive] = { accessRecorder =>
    new Decoder[Recursive] {
      def apply(prot: AdaptTProtocol): Recursive = new AccessRecordingWrapper(decodeInternal(prot, true), accessRecorder)
    }
  }
  private[this] val fallbackDecoder = new Decoder[Recursive] {
    def apply(prot: AdaptTProtocol): Recursive = decodeInternal(prot, true)
  }
  private[this] def adaptiveDecode(_iprot: AdaptTProtocol): Recursive = {
    val adaptContext = _iprot.adaptContext
    val reloadRequired = adaptContext.shouldReloadDecoder
    synchronized {
      if ((adaptiveDecoder eq null) || reloadRequired) {
        adaptiveDecoder = adaptContext.buildDecoder(this, fallbackDecoder, accessRecordingDecoderBuilder)
      }
    }
    adaptiveDecoder(_iprot)
  }

  /**
   * AccessRecordingWrapper keeps track of fields that are accessed while
   * delegating to underlying struct.
   */
  private[this] class AccessRecordingWrapper(underlying: Recursive, accessRecorder: AccessRecorder) extends Recursive {
    override def id: Long = {
      accessRecorder.fieldAccessed(1)
      underlying.id
    }
    override def recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = {
      accessRecorder.fieldAccessed(2)
      underlying.recRequest
    }
    override def write(_oprot: TProtocol): Unit = underlying.write(_oprot)

    override def _passthroughFields: immutable$Map[Short, TFieldBlob] = underlying._passthroughFields
  }

  override def decode(_iprot: TProtocol): Recursive = {
    if (_iprot.isInstanceOf[LazyTProtocol]) {
      decodeInternal(_iprot, true)
    } else if (_iprot.isInstanceOf[AdaptTProtocol]) {
      adaptiveDecode(_iprot.asInstanceOf[AdaptTProtocol])
    } else {
      decodeInternal(_iprot, false)
    }
  }

  private[thriftscala] def eagerDecode(_iprot: TProtocol): Recursive = {
    decodeInternal(_iprot, false)
  }

  private[this] def decodeInternal(_iprot: TProtocol, lazily: Boolean): Recursive = {
    var id: Long = 0L
    var recRequest: Option[com.twitter.scrooge.test.gold.thriftscala.Request] = None

    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = if (lazily) _iprot.asInstanceOf[LazyTProtocol].offset else -1

    _iprot.readStructBegin()
    do {
      val _field = _iprot.readFieldBegin()
      val _fieldType = _field.`type`
      if (_fieldType == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 =>
            _root_.com.twitter.scrooge.internal.TProtocols.validateFieldType(TType.I64, _fieldType, "id")
            id = _iprot.readI64()
          case 2 =>
            _root_.com.twitter.scrooge.internal.TProtocols.validateFieldType(TType.STRUCT, _fieldType, "recRequest")
            recRequest = _root_.scala.Some(com.twitter.scrooge.test.gold.thriftscala.Request.decode(_iprot))
          case _ =>
            _passthroughFields = _root_.com.twitter.scrooge.internal.TProtocols.readPassthroughField(_iprot, _field, _passthroughFields)
        }
        _iprot.readFieldEnd()
      }
    } while (!_done)
    _iprot.readStructEnd()


    val _passthroughFieldsResult =
      if (_passthroughFields eq null) _root_.com.twitter.scrooge.internal.TProtocols.NoPassthroughFields
      else _passthroughFields.result()
    if (lazily) {
      val _lazyProt = _iprot.asInstanceOf[LazyTProtocol]
      new LazyImmutable(
        _lazyProt,
        _lazyProt.buffer,
        _start_offset,
        _lazyProt.offset,
        id,
        recRequest,
        _passthroughFieldsResult
      )
    } else {
      new Immutable(
        id,
        recRequest,
        _passthroughFieldsResult
      )
    }
  }

  def apply(
    id: Long,
    recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = _root_.scala.None
  ): Recursive =
    new Immutable(
      id,
      recRequest
    )

  def unapply(_item: Recursive): _root_.scala.Option[_root_.scala.Tuple2[Long, Option[com.twitter.scrooge.test.gold.thriftscala.Request]]] = _root_.scala.Some(_item.toTuple)



  object Immutable extends ThriftStructCodec3[Recursive] {
    override def encode(_item: Recursive, _oproto: TProtocol): Unit = { _item.write(_oproto) }
    override def decode(_iprot: TProtocol): Recursive = Recursive.decode(_iprot)
    override lazy val metaData: ThriftStructMetaData[Recursive] = Recursive.metaData
  }

  /**
   * The default read-only implementation of Recursive.  You typically should not need to
   * directly reference this class; instead, use the Recursive.apply method to construct
   * new instances.
   */
  class Immutable(
      val id: Long,
      val recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Recursive {
    def this(
      id: Long,
      recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = _root_.scala.None
    ) = this(
      id,
      recRequest,
      immutable$Map.empty[Short, TFieldBlob]
    )
  }

  /**
   * This is another Immutable, this however keeps strings as lazy values that are lazily decoded from the backing
   * array byte on read.
   */
  private[this] class LazyImmutable(
      _proto: LazyTProtocol,
      _buf: Array[Byte],
      _start_offset: Int,
      _end_offset: Int,
      val id: Long,
      val recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request],
      override val _passthroughFields: immutable$Map[Short, TFieldBlob])
    extends Recursive {

    override def write(_oprot: TProtocol): Unit = {
      if (_oprot.isInstanceOf[LazyTProtocol]) {
        _oprot.asInstanceOf[LazyTProtocol].writeRaw(_buf, _start_offset, _end_offset - _start_offset)
      } else {
        super.write(_oprot)
      }
    }


    /**
     * Override the super hash code to make it a lazy val rather than def.
     *
     * Calculating the hash code can be expensive, caching it where possible
     * can provide significant performance wins. (Key in a hash map for instance)
     * Usually not safe since the normal constructor will accept a mutable map or
     * set as an arg
     * Here however we control how the class is generated from serialized data.
     * With the class private and the contract that we throw away our mutable references
     * having the hash code lazy here is safe.
     */
    override lazy val hashCode: Int = super.hashCode
  }

}

/**
 * Prefer the companion object's [[com.twitter.scrooge.test.gold.thriftscala.Recursive.apply]]
 * for construction if you don't need to specify passthrough fields.
 */
trait Recursive
  extends ThriftStruct
  with _root_.scala.Product2[Long, Option[com.twitter.scrooge.test.gold.thriftscala.Request]]
  with ValidatingThriftStruct[Recursive]
  with java.io.Serializable
{
  import Recursive._

  def id: Long
  def recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request]

  def _passthroughFields: immutable$Map[Short, TFieldBlob] = immutable$Map.empty

  def _1: Long = id
  def _2: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = recRequest

  def toTuple: _root_.scala.Tuple2[Long, Option[com.twitter.scrooge.test.gold.thriftscala.Request]] =
    _root_.scala.Tuple2[Long, Option[com.twitter.scrooge.test.gold.thriftscala.Request]](
      id,
      recRequest
    )


  /**
   * Gets a field value encoded as a binary blob using TCompactProtocol.  If the specified field
   * is present in the passthrough map, that value is returned.  Otherwise, if the specified field
   * is known and not optional and set to None, then the field is serialized and returned.
   */
  def getFieldBlob(_fieldId: Short): _root_.scala.Option[TFieldBlob] = {
    val passedthroughValue = _passthroughFields.get(_fieldId)
    if (passedthroughValue.isDefined) {
      passedthroughValue
    } else {
      val _buff = new TMemoryBuffer(32)
      val _oprot = new TCompactProtocol(_buff)

      val _fieldOpt: _root_.scala.Option[TField] = _fieldId match {
        case 1 =>
            _oprot.writeI64(id)
            _root_.scala.Some(Recursive.IdField)
        case 2 =>
          if (recRequest.isDefined) {
            recRequest.get.write(_oprot)
            _root_.scala.Some(Recursive.RecRequestField)
          } else {
            _root_.scala.None
          }
        case _ => _root_.scala.None
      }
      if (_fieldOpt.isDefined) {
        _root_.scala.Some(TFieldBlob(_fieldOpt.get, Buf.ByteArray.Owned(_buff.getArray)))
      } else {
        _root_.scala.None
      }
    }
  }


  /**
   * Collects TCompactProtocol-encoded field values according to `getFieldBlob` into a map.
   */
  def getFieldBlobs(ids: TraversableOnce[Short]): immutable$Map[Short, TFieldBlob] =
    (ids.flatMap { id => getFieldBlob(id).map { fieldBlob => (id, fieldBlob) } }).toMap

  /**
   * Sets a field using a TCompactProtocol-encoded binary blob.  If the field is a known
   * field, the blob is decoded and the field is set to the decoded value.  If the field
   * is unknown and passthrough fields are enabled, then the blob will be stored in
   * _passthroughFields.
   */
  def setField(_blob: TFieldBlob): Recursive = {
    var id: Long = this.id
    var recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = this.recRequest
    var _passthroughFields = this._passthroughFields
    val _iprot = _blob.read 
    _blob.id match {
      case 1 =>
        id = _iprot.readI64()
      case 2 =>
        recRequest = _root_.scala.Some(com.twitter.scrooge.test.gold.thriftscala.Request.decode(_iprot))
      case _ => _passthroughFields += _root_.scala.Tuple2(_blob.id, _blob)
    }
    new Immutable(
      id,
      recRequest,
      _passthroughFields
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetField(_fieldId: Short): Recursive = {
    var id: Long = this.id
    var recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = this.recRequest

    _fieldId match {
      case 1 =>
        id = 0L
      case 2 =>
        recRequest = _root_.scala.None
      case _ =>
    }
    new Immutable(
      id,
      recRequest,
      _passthroughFields - _fieldId
    )
  }

  /**
   * If the specified fields are optional, they are set to None.  Otherwise, if the fields are
   * known, they are reverted to their default values; if the fields are unknown, they are removed
   * from the passthroughFields map, if present.
   */
  def unsetFields(_fieldIds: Set[Short]): Recursive = {
    new Immutable(
      if (_fieldIds(1)) 0L else this.id,
      if (_fieldIds(2)) _root_.scala.None else this.recRequest,
      _passthroughFields -- _fieldIds
    )
  }

  /**
   * If the specified field is optional, it is set to None.  Otherwise, if the field is
   * known, it is reverted to its default value; if the field is unknown, it is removed
   * from the passthroughFields map, if present.
   */
  def unsetId: Recursive = unsetField(1)

  def unsetRecRequest: Recursive = unsetField(2)


  override def write(_oprot: TProtocol): Unit = {
    Recursive.validate(this)
    _oprot.writeStructBegin(Struct)
    _oprot.writeFieldBegin(IdField)
    _oprot.writeI64(id)
    _oprot.writeFieldEnd()
    if (recRequest.isDefined) {
      _oprot.writeFieldBegin(RecRequestField)
      recRequest.get.write(_oprot)
      _oprot.writeFieldEnd()
    }
    _root_.com.twitter.scrooge.internal.TProtocols.finishWritingStruct(_oprot, _passthroughFields)
  }

  def copy(
    id: Long = this.id,
    recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = this.recRequest,
    _passthroughFields: immutable$Map[Short, TFieldBlob] = this._passthroughFields
  ): Recursive =
    new Immutable(
      id,
      recRequest,
      _passthroughFields
    )

  override def canEqual(other: Any): Boolean = other.isInstanceOf[Recursive]

  private[this] def _equals(other: Recursive): Boolean =
      this.eq(other) || (
        this.productArity == other.productArity &&
        this.productIterator.sameElements(other.productIterator) &&
        this._passthroughFields == other._passthroughFields )

  override def equals(other: Any): Boolean =
    canEqual(other) && _equals(other.asInstanceOf[Recursive])

  override def hashCode: Int = {
    _root_.scala.runtime.ScalaRunTime._hashCode(this)
  }

  override def toString: String = _root_.scala.runtime.ScalaRunTime._toString(this)

  override def productPrefix: String = "Recursive"

  def _codec: ValidatingThriftStructCodec3[Recursive] = Recursive

  def newBuilder(): StructBuilder[Recursive] = new RecursiveStructBuilder(_root_.scala.Some(this), fieldTypes)
}

private[thriftscala] class RecursiveStructBuilder(instance: _root_.scala.Option[Recursive], fieldTypes: IndexedSeq[ClassTag[_]])
    extends StructBuilder[Recursive](fieldTypes) {

  def build(): Recursive = {
    val _fieldArray = fieldArray // shadow variable
    if (instance.isDefined) {
      val instanceValue = instance.get
      Recursive(
        if (_fieldArray(0) == null) instanceValue.id else _fieldArray(0).asInstanceOf[Long],
        if (_fieldArray(1) == null) instanceValue.recRequest else _fieldArray(1).asInstanceOf[_root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request]]
      )
    } else {
      if (genericArrayOps(_fieldArray).contains(null)) throw new InvalidFieldsException(structBuildError("Recursive"))
      Recursive(
        _fieldArray(0).asInstanceOf[Long],
        _fieldArray(1).asInstanceOf[_root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request]]
      )
    }
  }
}

private class Recursive__AdaptDecoder {

  def decode(_iprot: AdaptTProtocol): Recursive = {
    import Recursive._
    var _passthroughFields: Builder[(Short, TFieldBlob), immutable$Map[Short, TFieldBlob]] = null
    var _done = false
    val _start_offset = _iprot.offset

    val adapt = new Recursive__Adapt(
      _iprot,
      _iprot.buffer,
      _start_offset)

    AdaptTProtocol.usedStartMarker(1)
    var id: Long = 0L
    AdaptTProtocol.usedEndMarker(1)

    AdaptTProtocol.usedStartMarker(2)
    var recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = _root_.scala.None

    adapt.set_recRequest(recRequest)
    AdaptTProtocol.usedEndMarker(2)

    _iprot.readStructBegin()
    do {
      val _field = _iprot.readFieldBegin()
      val _fieldType = _field.`type`
      if (_field.`type` == TType.STOP) {
        _done = true
      } else {
        _field.id match {
          case 1 => {
            if (_fieldType == TType.I64) {
              AdaptTProtocol.usedStartMarker(1)
              id = _iprot.readI64()
              AdaptTProtocol.usedEndMarker(1)
              AdaptTProtocol.unusedStartMarker(1)
              _iprot.offsetSkipI64()
              AdaptTProtocol.unusedEndMarker(1)
            } else {
              throw AdaptTProtocol.unexpectedTypeException(
                TType.I64,
                _fieldType,
                "id"
              )
            }
            AdaptTProtocol.usedStartMarker(1)
            adapt.set_id(id)
            AdaptTProtocol.usedEndMarker(1)
          }
          case 2 => {
            if (_fieldType == TType.STRUCT) {
              AdaptTProtocol.usedStartMarker(2)
              recRequest = _root_.scala.Some(com.twitter.scrooge.test.gold.thriftscala.Request.decode(_iprot))
              AdaptTProtocol.usedEndMarker(2)
              AdaptTProtocol.unusedStartMarker(2)
              _iprot.offsetSkipStruct()
              AdaptTProtocol.unusedEndMarker(2)
            } else {
              throw AdaptTProtocol.unexpectedTypeException(
                TType.STRUCT,
                _fieldType,
                "recRequest"
              )
            }
            AdaptTProtocol.usedStartMarker(2)
            adapt.set_recRequest(recRequest)
            AdaptTProtocol.usedEndMarker(2)
          }
          case _ =>
            if (_passthroughFields eq null)
              _passthroughFields = immutable$Map.newBuilder[Short, TFieldBlob]
            _passthroughFields += _root_.scala.Tuple2(_field.id, TFieldBlob.read(_field, _iprot))
        }
        _iprot.readFieldEnd()
      }
    } while (!_done)
    _iprot.readStructEnd()

    adapt.set__endOffset(_iprot.offset)
    if (_passthroughFields ne null) {
      adapt.set__passthroughFields(_passthroughFields.result())
    }
    adapt
  }
}

/**
 * This is the base template for Adaptive decoding. This class gets pruned and
 * reloaded at runtime.
 */
private class Recursive__Adapt(
    _proto: AdaptTProtocol,
    _buf: Array[Byte],
    _start_offset: Int) extends Recursive {

  /**
   * In case any unexpected field is accessed, fallback to eager decoding.
   */
  private[this] lazy val delegate: Recursive = {
    val bytes = _root_.java.util.Arrays.copyOfRange(_buf, _start_offset, _end_offset)
    val proto = _proto.withBytes(bytes)
    Recursive.eagerDecode(proto)
  }

  private[this] var m_id: Long = _
  def set_id(id: Long): Unit = m_id = id
  // This will be removed by ASM if field is unused.
  def id: Long = m_id
  // This will be removed by ASM if field is used otherwise renamed to id.
  def delegated_id: Long = delegate.id

  private[this] var m_recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = _
  def set_recRequest(recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request]): Unit = m_recRequest = recRequest
  // This will be removed by ASM if field is unused.
  def recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = m_recRequest
  // This will be removed by ASM if field is used otherwise renamed to recRequest.
  def delegated_recRequest: _root_.scala.Option[com.twitter.scrooge.test.gold.thriftscala.Request] = delegate.recRequest


  private[this] var _end_offset: Int = _
  def set__endOffset(offset: Int): Unit = _end_offset = offset

  private[this] var __passthroughFields: immutable$Map[Short, TFieldBlob] = _root_.com.twitter.scrooge.internal.TProtocols.NoPassthroughFields
  def set__passthroughFields(passthroughFields: immutable$Map[Short, TFieldBlob]): Unit =
    __passthroughFields = passthroughFields

  override def _passthroughFields: immutable$Map[Short, TFieldBlob] = __passthroughFields

  /*
  Override the super hash code to make it a lazy val rather than def.

  Calculating the hash code can be expensive, caching it where possible
  can provide significant performance wins. (Key in a hash map for instance)
  Usually not safe since the normal constructor will accept a mutable map or
  set as an arg
  Here however we control how the class is generated from serialized data.
  With the class private and the contract that we throw away our mutable references
  having the hash code lazy here is safe.
  */
  override lazy val hashCode: Int = super.hashCode

  override def write(_oprot: TProtocol): Unit = {
    if (_oprot.isInstanceOf[AdaptTProtocol]) {
      _oprot.asInstanceOf[AdaptTProtocol].writeRaw(_buf, _start_offset, _end_offset - _start_offset)
    } else {
      super.write(_oprot)
    }
  }
}
