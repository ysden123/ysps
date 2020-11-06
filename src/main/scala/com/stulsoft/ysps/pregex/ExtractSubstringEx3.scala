/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.ysps.pregex

/**
 * @author Yuriy Stul
 */
private object ExtractSubstringEx3 extends App {
  test1()
  test2()
  test3()

  def extract(text: String): Option[String] = {
    val pattern = """abc(\d+).*""".r
    try {
      val pattern(n) = text
      Option(n)
    }catch {
      case ex:Exception => None
    }
  }

  def test1(): Unit = {
    println(s"""abc123 ms => [${extract("abc123 ms")}]""")
  }

  def test2(): Unit = {
    println(s"""abc123ms => [${extract("abc123ms")}]""")
  }

  def test3(): Unit = {
    println(s"""abcXXXms => [${extract("abcXXXms")}]""")
  }
}
