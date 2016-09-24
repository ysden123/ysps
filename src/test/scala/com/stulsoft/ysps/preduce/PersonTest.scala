package com.stulsoft.ysps.preduce

import org.scalatest.{FunSpec, Matchers}

/**
  * Created by Yuriy Stul on 9/24/2016.
  */
class PersonTest extends FunSpec with Matchers {
  describe("Person") {
    describe("#toString") {
      it("should return text representation") {
        val p = new Person(1, 150, "test")
        p.toString should equal("name: test, age = 1, height = 150")
      }
    }
  }
}
