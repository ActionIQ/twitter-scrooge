/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 *   source file: scrooge/scrooge-generator-tests/src/test/resources/gold_file_input/gold.thrift
 */


@import ApacheThrift.TBase;

@interface TFNTwitterThriftGoldCollectionId : NSObject <TBase, NSCoding>

@property (nonatomic) int64_t collectionLongId;
@property (nonatomic, readonly) BOOL collectionLongIdIsSet;


- (instancetype)initWithCollectionLongId:(int64_t)collectionLongId;
+ (instancetype)instanceWithCollectionLongId:(int64_t)collectionLongId error:(NSError **)error;
- (void)read:(id<TProtocol>)inProtocol;
- (void)write:(id<TProtocol>)outProtocol;

@end
