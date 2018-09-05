/*
 * Copyright (c) 2018. Yuriy Stul 
 */

package com.stulsoft.ysps.pforcomprehansion

import scala.util.Try

/**
  * @author Yuriy Stul
  */
object Example7 extends App {
  test1()
  test2()
  test3()
  test4()
  test5()

  def test1(): Unit = {
    println("==>test1")
    val result = for {
      _ <- f1(false)
      _ <- f2(false)
    } yield "Everything is OK"
    println(result)
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val result = for {
      _ <- f1(true)
      _ <- f2(false)
    } yield "Everything is OK"
    println(result)
    println("<==test2")
  }

  def f1(toFail: Boolean): Try[Boolean] = {
    Try(if (toFail)
      throw new RuntimeException("f1 failed")
    else
      true
    )
  }

  def f2(toFail: Boolean): Try[Boolean] = {
    Try(if (toFail)
      throw new RuntimeException("f2 failed")
    else
      true
    )
  }

  def test3(): Unit = {
    println("==>test3")
    val result = for {
      _ <- f1(true)
      _ <- f2(true)
    } yield "Everything is OK"
    println(result)
    println("<==test3")
  }

  def test4(): Unit = {
    println("==>test4")
    val result = for {
      _ <- f1(false)
      _ <- f2(true)
    } yield "Everything is OK"
    println(result)
    println("<==test4")
  }

  def test5(): Unit = {
    println("==>test5")
    val result1 = for {
      _ <- f1(false)
      _ <- f3(false)
    } yield "Everything is OK"
    println(s"result1=$result1")
    val result2 = for {
      _ <- f1(false)
      _ <- f3(true)
    } yield "Everything is OK"
    println(s"result2=$result2")
    println("<==test5")
  }

  def f3(toFail: Boolean): Try[Boolean] = {
    Try {
      if (toFail)
        throw new RuntimeException("f3 failed")
      else
        true
    }
  }
}
