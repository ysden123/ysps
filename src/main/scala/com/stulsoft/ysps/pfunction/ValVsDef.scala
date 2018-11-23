/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pfunction

import scala.util.Random

/** Demonstrates difference between val and def for function.
  *
  * @author Yuriy Stul
  */
object ValVsDef extends App {
  val v1: () => Int = {
    val r = Random.nextInt() // Evaluates 1 time, when defined!
    () => r
  }

  def f2: () => Int = {
    val r = Random.nextInt() // Evaluates each time, when called!
    () => r
  }

  def f3(): Int = {
    val r = Random.nextInt() // Evaluates each time, when called!
    r
  }

  val v2: () => Int = {
    val r = {
      println("Initializing r in v2")
      Random.nextInt() // Evaluates 1 time, when defined!
    }
    () => r
  }

  lazy val v3: () => Int = {
    val r = {
      println("Initializing r in v3")
      Random.nextInt() // Evaluates 1 time, when defined!
    }
    () => r
  }

  def test1(): Unit = {
    println("==>test1")
    println(s"v1()=${v1()} - same result")
    println(s"v1()=${v1()} - same result")
    println(s"f2()=${f2()} - different result")
    println(s"f2()=${f2()} - different result")
    println(s"f3()=${f3()} - different result")
    println(s"f3()=${f3()} - different result")
    println(s"v2()=${v2()} - same result")
    println(s"v2()=${v2()} - same result")
    println(s"v3()=${v3()} - same result")
    println(s"v3()=${v3()} - same result")
    println("<==test1")
  }

  test1()
}
