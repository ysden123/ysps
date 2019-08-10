/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.ptry

import scala.util.{Failure, Success, Try}

/** Try with foreach
  *
  * <p>
  * Works for <i>Success</i> only
  *
  * <p>
  * Use <i>Try.foreach</i> only, if You need success results only.
  *
  * @author Yuriy Stul
  */
object TryWithForeach extends App {
  val fail = true
  val success = false

  test1()
  test2()
  test3()
  test4()
  test5()
  test6()

  def foo(toFail: Boolean): Try[String] = {
    Try {
      if (toFail) {
        throw new RuntimeException("test exception")
      }
      else
        "test text"
    }
  }

  def test1(): Unit = {
    println("==>test1")
    foo(success).foreach(s => println(s"Result: $s"))
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    foo(fail).foreach(s => println(s"Result: $s"))
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    showResult(foo(success))
    println("<==test3")
  }

  def test4(): Unit = {
    println("==>test4")
    showResult(foo(fail))
    println("<==test4")
  }

  def test5(): Unit = {
    println("==>test5")
    showResult2(foo(success))
    println("<==test5")
  }
  
  def test6(): Unit = {
    println("==>test6")
    showResult2(foo(fail))
    println("<==test6")
  }

  def showResult(result: Try[String]): Unit = {
    result match {
      case Success(s) => println(s"Result: $s")
      case Failure(ex) => println(s"Error: ${ex.getMessage}")
    }
  }
  
  def showResult2(result: Try[String]): Unit ={
    println(result.fold(
      ex => s"Error: ${ex.getMessage}",
      v => s"Result: $v"
    ))
    
  }
}
