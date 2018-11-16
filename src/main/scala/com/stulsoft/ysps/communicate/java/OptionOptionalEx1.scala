/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.communicate.java

/** Demonstrates usage of Option (Scala) and Optional (Java)
  *
  * @author Yuriy Stul
  */
object OptionOptionalEx1 extends App {
  val optionOptionalJava = new OptionOptionalJava

  private def test(exist: Boolean): Unit = {
    val resultFromJava = optionOptionalJava.f1(exist)
    println(s"""exist is $exist, result= ${if (resultFromJava.isPresent) resultFromJava.get() else "undefined"}""")
  }

  test(true)
  test(false)
}

object OptionOptionalEx1Service {
  def f1(exist: Boolean): Option[String] = {
    if (exist)
      Option("Some text")
    else
      None
  }
}
