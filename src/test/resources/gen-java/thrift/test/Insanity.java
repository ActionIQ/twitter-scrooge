/**
 * Autogenerated by Thrift
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 */
package thrift.test;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.thrift.*;
import org.apache.thrift.async.*;
import org.apache.thrift.meta_data.*;
import org.apache.thrift.transport.*;
import org.apache.thrift.protocol.*;

public class Insanity implements TBase<Insanity, Insanity._Fields>, java.io.Serializable, Cloneable {
  private static final TStruct STRUCT_DESC = new TStruct("Insanity");

  private static final TField USER_MAP_FIELD_DESC = new TField("userMap", TType.MAP, (short)1);
  private static final TField XTRUCTS_FIELD_DESC = new TField("xtructs", TType.LIST, (short)2);

  public Map<Numberz,Long> userMap;
  public List<Xtruct> xtructs;

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements TFieldIdEnum {
    USER_MAP((short)1, "userMap"),
    XTRUCTS((short)2, "xtructs");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // USER_MAP
          return USER_MAP;
        case 2: // XTRUCTS
          return XTRUCTS;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments

  public static final Map<_Fields, FieldMetaData> metaDataMap;
  static {
    Map<_Fields, FieldMetaData> tmpMap = new EnumMap<_Fields, FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.USER_MAP, new FieldMetaData("userMap", TFieldRequirementType.DEFAULT, 
        new MapMetaData(TType.MAP, 
            new EnumMetaData(TType.ENUM, Numberz.class), 
            new FieldValueMetaData(TType.I64            , "UserId"))));
    tmpMap.put(_Fields.XTRUCTS, new FieldMetaData("xtructs", TFieldRequirementType.DEFAULT, 
        new ListMetaData(TType.LIST, 
            new StructMetaData(TType.STRUCT, Xtruct.class))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    FieldMetaData.addStructMetaDataMap(Insanity.class, metaDataMap);
  }

  public Insanity() {
  }

  public Insanity(
    Map<Numberz,Long> userMap,
    List<Xtruct> xtructs)
  {
    this();
    this.userMap = userMap;
    this.xtructs = xtructs;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public Insanity(Insanity other) {
    if (other.isSetUserMap()) {
      Map<Numberz,Long> __this__userMap = new HashMap<Numberz,Long>();
      for (Map.Entry<Numberz, Long> other_element : other.userMap.entrySet()) {

        Numberz other_element_key = other_element.getKey();
        Long other_element_value = other_element.getValue();

        Numberz __this__userMap_copy_key = other_element_key;

        Long __this__userMap_copy_value = other_element_value;

        __this__userMap.put(__this__userMap_copy_key, __this__userMap_copy_value);
      }
      this.userMap = __this__userMap;
    }
    if (other.isSetXtructs()) {
      List<Xtruct> __this__xtructs = new ArrayList<Xtruct>();
      for (Xtruct other_element : other.xtructs) {
        __this__xtructs.add(new Xtruct(other_element));
      }
      this.xtructs = __this__xtructs;
    }
  }

  public Insanity deepCopy() {
    return new Insanity(this);
  }

  @Override
  public void clear() {
    this.userMap = null;
    this.xtructs = null;
  }

  public int getUserMapSize() {
    return (this.userMap == null) ? 0 : this.userMap.size();
  }

  public void putToUserMap(Numberz key, long val) {
    if (this.userMap == null) {
      this.userMap = new HashMap<Numberz,Long>();
    }
    this.userMap.put(key, val);
  }

  public Map<Numberz,Long> getUserMap() {
    return this.userMap;
  }

  public Insanity setUserMap(Map<Numberz,Long> userMap) {
    this.userMap = userMap;
    return this;
  }

  public void unsetUserMap() {
    this.userMap = null;
  }

  /** Returns true if field userMap is set (has been asigned a value) and false otherwise */
  public boolean isSetUserMap() {
    return this.userMap != null;
  }

  public void setUserMapIsSet(boolean value) {
    if (!value) {
      this.userMap = null;
    }
  }

  public int getXtructsSize() {
    return (this.xtructs == null) ? 0 : this.xtructs.size();
  }

  public java.util.Iterator<Xtruct> getXtructsIterator() {
    return (this.xtructs == null) ? null : this.xtructs.iterator();
  }

  public void addToXtructs(Xtruct elem) {
    if (this.xtructs == null) {
      this.xtructs = new ArrayList<Xtruct>();
    }
    this.xtructs.add(elem);
  }

  public List<Xtruct> getXtructs() {
    return this.xtructs;
  }

  public Insanity setXtructs(List<Xtruct> xtructs) {
    this.xtructs = xtructs;
    return this;
  }

  public void unsetXtructs() {
    this.xtructs = null;
  }

  /** Returns true if field xtructs is set (has been asigned a value) and false otherwise */
  public boolean isSetXtructs() {
    return this.xtructs != null;
  }

  public void setXtructsIsSet(boolean value) {
    if (!value) {
      this.xtructs = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case USER_MAP:
      if (value == null) {
        unsetUserMap();
      } else {
        setUserMap((Map<Numberz,Long>)value);
      }
      break;

    case XTRUCTS:
      if (value == null) {
        unsetXtructs();
      } else {
        setXtructs((List<Xtruct>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case USER_MAP:
      return getUserMap();

    case XTRUCTS:
      return getXtructs();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been asigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case USER_MAP:
      return isSetUserMap();
    case XTRUCTS:
      return isSetXtructs();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof Insanity)
      return this.equals((Insanity)that);
    return false;
  }

  public boolean equals(Insanity that) {
    if (that == null)
      return false;

    boolean this_present_userMap = true && this.isSetUserMap();
    boolean that_present_userMap = true && that.isSetUserMap();
    if (this_present_userMap || that_present_userMap) {
      if (!(this_present_userMap && that_present_userMap))
        return false;
      if (!this.userMap.equals(that.userMap))
        return false;
    }

    boolean this_present_xtructs = true && this.isSetXtructs();
    boolean that_present_xtructs = true && that.isSetXtructs();
    if (this_present_xtructs || that_present_xtructs) {
      if (!(this_present_xtructs && that_present_xtructs))
        return false;
      if (!this.xtructs.equals(that.xtructs))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    return 0;
  }

  public int compareTo(Insanity other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    Insanity typedOther = (Insanity)other;

    lastComparison = Boolean.valueOf(isSetUserMap()).compareTo(typedOther.isSetUserMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserMap()) {
      lastComparison = TBaseHelper.compareTo(this.userMap, typedOther.userMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetXtructs()).compareTo(typedOther.isSetXtructs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetXtructs()) {
      lastComparison = TBaseHelper.compareTo(this.xtructs, typedOther.xtructs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(TProtocol iprot) throws TException {
    TField field;
    iprot.readStructBegin();
    while (true)
    {
      field = iprot.readFieldBegin();
      if (field.type == TType.STOP) { 
        break;
      }
      switch (field.id) {
        case 1: // USER_MAP
          if (field.type == TType.MAP) {
            {
              TMap _map4 = iprot.readMapBegin();
              this.userMap = new HashMap<Numberz,Long>(2*_map4.size);
              for (int _i5 = 0; _i5 < _map4.size; ++_i5)
              {
                Numberz _key6;
                long _val7;
                _key6 = Numberz.findByValue(iprot.readI32());
                _val7 = iprot.readI64();
                this.userMap.put(_key6, _val7);
              }
              iprot.readMapEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        case 2: // XTRUCTS
          if (field.type == TType.LIST) {
            {
              TList _list8 = iprot.readListBegin();
              this.xtructs = new ArrayList<Xtruct>(_list8.size);
              for (int _i9 = 0; _i9 < _list8.size; ++_i9)
              {
                Xtruct _elem10;
                _elem10 = new Xtruct();
                _elem10.read(iprot);
                this.xtructs.add(_elem10);
              }
              iprot.readListEnd();
            }
          } else { 
            TProtocolUtil.skip(iprot, field.type);
          }
          break;
        default:
          TProtocolUtil.skip(iprot, field.type);
      }
      iprot.readFieldEnd();
    }
    iprot.readStructEnd();

    // check for required fields of primitive type, which can't be checked in the validate method
    validate();
  }

  public void write(TProtocol oprot) throws TException {
    validate();

    oprot.writeStructBegin(STRUCT_DESC);
    if (this.userMap != null) {
      oprot.writeFieldBegin(USER_MAP_FIELD_DESC);
      {
        oprot.writeMapBegin(new TMap(TType.I32, TType.I64, this.userMap.size()));
        for (Map.Entry<Numberz, Long> _iter11 : this.userMap.entrySet())
        {
          oprot.writeI32(_iter11.getKey().getValue());
          oprot.writeI64(_iter11.getValue());
        }
        oprot.writeMapEnd();
      }
      oprot.writeFieldEnd();
    }
    if (this.xtructs != null) {
      oprot.writeFieldBegin(XTRUCTS_FIELD_DESC);
      {
        oprot.writeListBegin(new TList(TType.STRUCT, this.xtructs.size()));
        for (Xtruct _iter12 : this.xtructs)
        {
          _iter12.write(oprot);
        }
        oprot.writeListEnd();
      }
      oprot.writeFieldEnd();
    }
    oprot.writeFieldStop();
    oprot.writeStructEnd();
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Insanity(");
    boolean first = true;

    sb.append("userMap:");
    if (this.userMap == null) {
      sb.append("null");
    } else {
      sb.append(this.userMap);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("xtructs:");
    if (this.xtructs == null) {
      sb.append("null");
    } else {
      sb.append(this.xtructs);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws TException {
    // check for required fields
  }

}

