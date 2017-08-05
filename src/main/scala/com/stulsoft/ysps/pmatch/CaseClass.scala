/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pmatch

/**
  * @author Yuriy Stul
  */
object CaseClass extends App {

  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")

    def analyze(t: CaseTestClass) = t match {
      case CaseTestClass(p) if p > 100 => "good"
      case _ => "bad"
    }

    val t1 = CaseTestClass(123)
    println(s"${analyze(t1)}")

    val t2 = CaseTestClass(12)
    println(s"${analyze(t2)}")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val t1 = CaseTestClass(123)
    val r1 = t1 match {
      case CaseTestClass(p) => s"caseTestClass with p = $p"
      case _ => "unknown"
    }
    println(s"r1: $r1")

    val t2 = CaseTestClass(7)
    val r2 = t2 match {
      case CaseTestClass(7) => s"caseTestClass with p = 7"
      case _ => "unknown"
    }
    println(s"r2: $r2")

    val t3 = CaseTestClass(77)
    val r3 = t3 match {
      case CaseTestClass(7) => s"caseTestClass with p = 7"
      case _ => "unknown"
    }
    println(s"r3: $r3")
    println("<==test2")
  }

  case class CaseTestClass(p: Int)

}
