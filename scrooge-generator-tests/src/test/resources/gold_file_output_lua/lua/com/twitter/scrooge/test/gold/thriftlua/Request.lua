--[[
  Generated by Scrooge
    version: ?
    rev: ?
    built at: ?
    source file: scrooge/scrooge-generator-tests/src/test/resources/gold_file_input/gold.thrift
--]]
--[[
/**
 * Request struct docstring
 */
--]]

-- Import this file with:
--   require 'com.twitter.scrooge.test.gold.thriftlua.Request'
-- Note: This file depends on libthrift!

local Recursive = require 'com.twitter.scrooge.test.gold.thriftlua.Recursive'

local Request = {
  ttype = 'struct',
  name = 'Request',
  fields = { }
}

Request.fields[1] = { name = 'aList', required = true, ttype = 'list', value = 'string', }
Request.fields[2] = { name = 'aSet', required = true, ttype = 'set', value = 'i32', }
Request.fields[3] = { name = 'aMap', required = true, ttype = 'map', key = 'i64', value = 'i64', }
Request.fields[4] = { name = 'aRequest', ttype = 'struct', fields = Request.fields, }
Request.fields[5] = { name = 'subRequests', required = true, ttype = 'list', value = Request, }
Request.fields[6] = { name = '_default', required = true, ttype = 'string', }
Request.fields[7] = { name = 'noComment', ttype = 'i64', }
Request.fields[8] = { name = 'doubleSlashComment', ttype = 'i64', }
Request.fields[9] = { name = 'hashtagComment', ttype = 'i64', }
Request.fields[10] = { name = 'singleAsteriskComment', ttype = 'i64', }
Request.fields[11] = { name = 'docStringComment', ttype = 'i64', }
Request.fields[12] = { name = 'recRequest', ttype = 'struct', fields = Recursive.fields, }
Request.fields[13] = { name = 'requiredField', required = true, ttype = 'string', }
Request.fields[14] = { name = 'constructionRequiredField', ttype = 'i64', }
Request.fields[15] = { name = 'anInt8', ttype = 'byte', }
Request.fields[16] = { name = 'aBinaryField', ttype = 'binary', }

local binaryCodec = require 'libthrift'

Request.__codec = binaryCodec.codec(Request)

function Request:read(bin)
  return self.__codec:read(bin)
end

function Request:readTensor(bin)
  return self.__codec:readTensor(bin)
end

function Request:write(params)
  return self.__codec:write(params)
end

function Request:writeTensor(params)
  return self.__codec:writeTensor(params)
end

return Request
