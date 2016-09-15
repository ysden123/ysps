package com.stulsoft.ysps.unittest

import org.scalatest.{FunSpec, Matchers}

/**
  * @author Yuriy Stul.
  *         Created on 9/15/2016.
  */
class ForUnitTestTest extends FunSpec with Matchers {
  describe("ForUnitTest") {
    describe("#test") {
      it("should run test") {
        val t = new ForUnitTest
        assert(t != null)
        t should not be null
        t.test()
      }
    }
    describe("#increase") {
      it("should increase by 1") {
        val t = new ForUnitTest
        assert(t != null)
        t should not be null
        assert(t.increase(5) == 6)
        val r = t.increase(7)
        r should equal(8)
      }
    }
  }
}
