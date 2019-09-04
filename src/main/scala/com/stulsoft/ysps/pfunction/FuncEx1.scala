/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pfunction

/**
  * @author Yuriy Stul
  */
object FuncEx1 extends App {

  test1()
  test2()
  test3()

  def test1(): Unit = {
    println("==>test1")
    val r1 = f1("Test")
    val r2 = f1(ft1())
    println(s"r1: $r1")
    println(s"r2: $r2")
  }

  def test2(): Unit = {
    println("==>test2")
    val r1 = f2(123, ft2)
    val r2 = f2(123, i => i.toString)
    println(s"r1: $r1")
    println(s"r2: $r2")
  }

  def test3(): Unit = {
    println("==>test3")
    val r1 = f3(1, 2L, (_, _) => "Test 33")
    val r2 = f3(1,2L, ft3)
    println(s"r1: $r1")
    println(s"r2: $r2")
  }

  def ft1(): String = {
    "Some test"
  }

  def ft2(i: Int): String = {
    i.toString + "s"
  }

  def ft3(i: Int, l: Long): String = {
    i.toString + " " + l.toString
  }

  def f1(f: => String): String = {
    f
  }

  def f2(i: Int, f: Int => String): String = {
    f(i)
  }

  def f3(i: Int, l: Long, f: (Int, Long) => String): String = {
    f(i, l)
  }
}
