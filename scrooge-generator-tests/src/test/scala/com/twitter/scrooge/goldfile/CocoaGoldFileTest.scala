package com.twitter.scrooge.goldfile

import com.twitter.scrooge.backend.CocoaGeneratorFactory

class CocoaGoldFileTest extends GoldFileTest {

  /*
   * The gold files can be regenerated via the command
   * source $ ./pants run scrooge-internal/generator:bin --jvm-run-jvm-program-args="--language cocoa --finagle --java-passthrough --gen-adapt --dest scrooge/scrooge-generator-tests/src/test/resources/gold_file_output_cocoa/ scrooge/scrooge-generator-tests/src/test/resources/gold_file_input/gold.thrift"
   */

  protected def language: String = CocoaGeneratorFactory.language

}
