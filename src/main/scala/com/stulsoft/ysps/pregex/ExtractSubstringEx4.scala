/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.ysps.pregex

/**
 * @author Yuriy Stul
 */
private object ExtractSubstringEx4 extends App {
  test1()
  test2()
  test3()
  test4()
  test5()
  test6()

  def extract(text: String): Option[Int] = {
    val number = """abc(\d+).*""".r
    text match {
      case number(n) => Option(n.toInt)
      case _ => None
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

  def test4(): Unit ={
    print("abc123 ms => ")
    extract("abc123 ms").foreach(n => print(n + 5))
    println()
  }

  def test5(): Unit ={
    print("abc123ms => ")
    extract("abc123ms").foreach(n => print(n + 5))
    println()
  }

  def test6(): Unit ={
    print("abc123ms => ")
    extract("abcXXXms").foreach(n => print(n + 5))
    println()
  }
}
