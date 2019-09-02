/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pvariance

/**
  * @author Yuriy Stul
  */
object InvariantEx1 extends App {
  val a = new A(123)
  val b = new B(4, "test")

  println(s"pInvariantA.f(a) = ${PInvariantA.f(a)}")
  println(s"pInvariantA.f(b) = ${PInvariantA.f(b)}")

  // Error:
  //  println(s"pInvariantB.f(a) = ${PInvariantB.f(a)}")
  println(s"pInvariantB.f(b) = ${PInvariantB.f(b)}")
}

class A(val n: Int)

class B(override val n: Int, val s: String) extends A(n)

object PInvariantA {
  def f(a: A): String = a.n.toString
}

object PInvariantB {
  def f(b: B): String = b.n.toString
}
