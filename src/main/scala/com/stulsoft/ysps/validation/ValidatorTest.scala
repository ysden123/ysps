/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.ysps.validation

/**
 * @author Yuriy Stul
 */
object ValidatorTest extends App {
  println("==>main")

  test1()

  def test1(): Unit = {
    println("==>test1")
    makeValidation("text")
    makeValidation("hghjghgjhgj")
    makeValidation("hghjgagjhgj")
  }

  def makeValidation(text: String): Unit = {
    println(s"==>makeValidation $text")
    val validator = Validator(text)
      .withValidator(anObject => anObject.contains("a"), "contains a")
      .withValidator(anObject => anObject.endsWith("t"), "ends with t")
    validator.validate().foreach(println)
  }
}
