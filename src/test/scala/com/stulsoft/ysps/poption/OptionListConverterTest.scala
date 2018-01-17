package com.stulsoft.ysps.poption

import org.scalatest.{FlatSpec, Matchers}

/**
  * @author Yuriy Stul.
  */
class OptionListConverterTest extends FlatSpec with Matchers {
  behavior of "OptionListConverter"

  "extract" should "handle List" in {
    val r = OptionListConverter.extract(List(Some("test1"), None, Some("test2")))
    r.size shouldBe 2
    r.head shouldBe "test1"
    r.tail.head shouldBe "test2"
  }

  it should "handle Seq" in {
    val r = OptionListConverter.extract(Seq(Some("test1"), None, Some("test2")))
    r.size shouldBe 2
    r.head shouldBe "test1"
    r.tail.head shouldBe "test2"
  }

  it should "handle Vector" in {
    val r = OptionListConverter.extract(Vector(Some("test1"), None, Some("test2")))
    r.size shouldBe 2
    r.head shouldBe "test1"
    r.tail.head shouldBe "test2"
  }

  it should "handle Set" in {
    val r = OptionListConverter.extract(Set(Some("test1"), None, Some("test2")))
    r.size shouldBe 2
    r.head shouldBe "test1"
    r.tail.head shouldBe "test2"
  }

}
