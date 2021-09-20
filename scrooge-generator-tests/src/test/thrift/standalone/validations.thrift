#@namespace scala com.twitter.scrooge.backend.thriftscala

struct ValidationStruct {
  1: string stringField (validation.length.min = "6", validation.email = "")
  2: i32 intField (validation.positiveOrZero = "")
  3: i64 longField (validation.max = "100")
  4: i16 shortField (validation.negative = "")
  5: i8 byteField (validation.positive = "")
  6: map<string, string> mapField (validation.size.max = "1")
  7: bool boolField (validation.assertTrue = "")
  8: required string requiredField
  9: optional string optionalField
}

// skip annotations not used for ThriftValidator
struct NonValidationStruct {
  1: string stringField (structFieldKey = "")
}

struct NestedValidationStruct {
  1: string stringField (validation.email = "")
  2: ValidationStruct nestedStructField
  // we don't support validating each struct in containers,
  // the annotations on a container type will be applied to
  // the container itself.
  3: list<ValidationStruct> nestedStructSet (validation.size.max = "1")
}

union ValidationUnion {
  1: i32 intField (validation.positiveOrZero = "")
  2: string stringField (validation.notEmpty = "")
}

exception ValidationException {
  1: string excField (validation.notEmpty = "")
}