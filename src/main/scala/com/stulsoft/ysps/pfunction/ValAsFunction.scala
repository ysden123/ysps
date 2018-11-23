/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pfunction

/**
  * @author Yuriy Stul
  */
object ValAsFunction extends App {
  val f1 = (s: String) => {
    println(s"In f1($s)")
    s.length
  }

  def test1(): Unit = {
    println("==>test1")
    println(s"""f1("text1") = ${f1("text1")}""")
    println("<==test1")
  }

  def test2(f: String => Int):Unit={
    println("==>test2")
    println(s"""f("text2") = ${f("text2")}""")
    println("<==test2")
  }

  test1()
  test2(f1)
}
