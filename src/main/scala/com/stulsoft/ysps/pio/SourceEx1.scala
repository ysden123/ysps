/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pio

import scala.io.Source

/**
  * @author Yuriy Stul
  */
object SourceEx1 extends App {
  test1()
  test2()
  test3()

  def test1(): Unit = {
    println("==>test1")
    val content =
      """line1 22
        |line2 33
        |line3 44
      """.stripMargin
    val source = Source.fromString(content)

    println(s"source.nerrors=${source.nerrors}") // 0

    source.reportError(1, "Some error report: ")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val content =
      """line1 22
        |line2 33
        |line3 44
      """.stripMargin
    val source = Source.fromString(content)

    val sb1 = new StringBuilder
    val sb2 = source.addString(sb1)

    println(s"sb2: $sb2")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    val content =
      """line1 22
        |line2 33
        |line3 44
      """.stripMargin
    val source = Source.fromString(content)

    source.close()

    println("<==test3")
  }
}
