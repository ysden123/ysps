/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pquestionmarks

/**
  * Demonstrates usage of three questions marks
  *
  * @author Yuriy Stul
  */
trait TraitEx01 {
  def f1(i: Int): Int = ???

  def f2(i: Int): Int = i + 17
}

object TraitEx01TestRunner extends App {
  println("==>main")

  val t1 = new TraitEx01 {}
  //  println(s"t1.f1(3) = ${t1.f1(3)}")  // scala.NotImplementedError: an implementation is missing
  println(s"t1.f2(3) = ${t1.f2(3)}")

  println("<==main")
}