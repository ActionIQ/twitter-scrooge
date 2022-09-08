/**
 * Generated by Scrooge
 *   version: ?
 *   rev: ?
 *   built at: ?
 *   source file: scrooge/scrooge-generator-tests/src/test/resources/gold_file_input/gold.thrift
 */
#import <TFNTwitterThriftGold/TFNTwitterThriftGoldRequest.h>

@import ApacheThrift.TBase;

@interface TFNTwitterThriftGoldRecursive : NSObject <TBase, NSCoding>

@property (nonatomic) int64_t id_;
@property (nonatomic, readonly) BOOL id_IsSet;

@property (nonatomic) TFNTwitterThriftGoldRequest* recRequest;
@property (nonatomic, readonly) BOOL recRequestIsSet;


- (instancetype)initWithId_:(int64_t)id_;
+ (instancetype)instanceWithId_:(int64_t)id_ error:(NSError **)error;
- (void)read:(id<TProtocol>)inProtocol;
- (void)write:(id<TProtocol>)outProtocol;

@end