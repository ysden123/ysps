package com.stulsoft.ysps.util

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul.
  */
class BenchmarkResultTest extends FlatSpec with Matchers {
  behavior of "BenchmarkResult"
  "constructor" should "create instance with Integer value" in {
    val r = BenchmarkResult(1, "test", 2)
    r should not be (null)
  }

  it should "create instance with TestResult value" in {
    val r = BenchmarkResult(1, "test", TestResult("the test", 15))
    r should not be (null)
    r.value.value shouldBe 15
  }
  "toString" should "return correct text" in {
    val r = BenchmarkResult(1, "test", TestResult("the test", 15))
    r.toString shouldBe "test: value=TestResult(the test,15), duration=1"
  }
}

case class TestResult(name: String, value: Long)