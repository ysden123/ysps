/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.ptry

import scala.util.Try

/** Working around exception handling model.
  *
  * Return unhandled exceptions.
  *
  * @author Yuriy Stul
  */
object PTry2 extends App {
  test1()
  test2()
  test3()

  def f1(throwException: Boolean): Unit = {
    println("==>f1")
    if (throwException) throw new RuntimeException("test exception1")
  }

  def f2(throwException: Boolean): Unit = {
    println("==>f2")
    if (throwException) throw new Exception("test exception2")
  }

  def test1(): Unit = {
    println("==>test1")
    val result = Try {
      f1(false)
      f2(false)
      "test1"
    }

    println(s"result is $result")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val result = Try {
      f1(true)
      f2(false)
      "test2"
    }

    println(s"result is $result")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    val result = Try {
      f1(false)
      f2(true)
      "test3"
    }

    println(s"result is $result")
    println("<==test3")
  }
}
