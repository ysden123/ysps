package com.stulsoft.ysps.preduce

import org.scalatest.funspec.AnyFunSpec
import org.scalatest.matchers.should.Matchers


/**
  * Created by Yuriy Stul on 9/24/2016.
  */
class PersonTest extends AnyFunSpec with Matchers {
  describe("Person") {
    describe("#toString") {
      it("should return text representation") {
        val p = Person(1, 150, "test")
        p.toString should equal("name: test, age = 1, height = 150")
      }
    }
  }
}
