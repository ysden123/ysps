/*
 * Copyright (c) 2018. Yuriy Stul 
 */

package com.stulsoft.ysps.pforcomprehansion

import scala.util.{Failure, Success, Try}

/**
  * @author Yuriy Stul
  */
object Example6 extends App {
  test1()
  test2()
  test3()
  test4()

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

  def f1(toFail: Boolean): Try[Boolean] = {
    if (toFail)
      Failure(new RuntimeException("f1 failed"))
    else
      Success(true)
  }

  def f2(toFail: Boolean): Try[Boolean] = {
    if (toFail)
      Failure(new RuntimeException("f2 failed"))
    else
      Success(true)
  }
}
