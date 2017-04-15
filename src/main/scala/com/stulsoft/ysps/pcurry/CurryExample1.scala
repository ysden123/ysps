/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pcurry

/**
  * @author Yuriy Stul
  */
object CurryExample1 extends App {
  def testCurryF1(): Unit = {
    println("==>testCurryF1")
    val c1 = curryF1(13)(_)
    val c2 = curryF1(17)(_)
    val r1 = c1(2)
    val r2 = c2(2)
    println(s"r1 = $r1")
    println(s"r2 = $r2")
    println("<==testCurryF1")
  }

  /**
    * Curring with two parameters
    *
    * @param p1 1st parameter
    * @param p2 2nd parameter
    * @return result
    */
  def curryF1(p1: Int)(p2: Int): Int = {
    println("==>curryF1")
    p1 * p2
  }

  def testCurryF2(): Unit = {
    println("==>testCurryF2")
    val c1 = curryF2("short text".length)(_)
    val c2 = curryF2("very long text".length)(_)
    val c3 = curryF2({
      println("A some test")
      22
    })(_)
    val r1 = c1(2)
    val r2 = c2(2)
    val r3 = c3(2)
    println(s"r1 = $r1")
    println(s"r2 = $r2")
    println(s"r3 = $r3")
    println("<==testCurryF2")
  }

  /**
    * Curring with function and parameter
    *
    * @param f1 a function (a block)
    * @param p2 2nd parameter
    * @return result
    */
  def curryF2(f1: => Int)(p2: Int): Int = {
    println("==>curryF2")
    f1 * p2
  }

  def testCurryF3(): Unit = {
    println("==>testCurryF3")

    def f(): Int = {
      println("A some test")
      33
    }

    val c1 = curryF3(() => f())(_)
    val r1 = c1(2)
    println(s"r1 = $r1")
    println("<==testCurryF3")
  }

  /**
    * Curring with function and parameter
    *
    * @param f1 a function (a function)
    * @param p2 2nd parameter
    * @return result
    */
  def curryF3(f1: () => Int)(p2: Int): Int = {
    println("==>curryF3")
    f1() * p2
  }

  def testCurryF4(): Unit = {
    println("==>testCurryF4")

    def f(s: String): Int = s.length

    val c1 = curryF4(f)("the text 1")(_)
    val c2 = curryF4(s => s.length)("the text 2")(_)
    val r1 = c1(2)
    val r2 = c2(3)
    println(s"r1 = $r1")
    println(s"r2 = $r2")
    println("<==testCurryF4")
  }

  /**
    * Curring with function and parameters
    *
    * @param f1 a function
    * @param p2 2nd parameter
    * @param p3 3rd parameter
    * @return result
    */
  def curryF4(f1: (String) => Int)(p2: String)(p3: Int): Int = {
    println("==>curryF4")
    f1(p2) * p3
  }

  println("==>main")
  testCurryF1()
  testCurryF2()
  testCurryF3()
  testCurryF4()
  println("<==main")
}
