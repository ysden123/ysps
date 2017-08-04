/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pmatch

/** Demonstrates usage of pattern match for non-case class
  *
  * @author Yuriy Stul
  */
object NoCaseClass extends App {

  test()

  def test(): Unit = {
    println("==>test")

    def analyze(t: TestClass) = t match {
      case p: TestClass if p.p > 100 => "good"
      case _ => "bad"
    }

    val t1 = new TestClass(123)
    println(s"${analyze(t1)}")

    val t2 = new TestClass(12)
    println(s"${analyze(t2)}")
    println("<==test")
  }

  class TestClass(val p: Int)

}
