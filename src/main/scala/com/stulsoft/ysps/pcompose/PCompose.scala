/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.pcompose

/**
  * Olaying with compose
  *
  * @author Yuriy Stul
  */
object PCompose extends App {
  println("==>PCompose")

  /**
    * Compose two functions
    */
  private def test1(): Unit = {
    println("==>test1")
    val f1: Int => Int = i => i * 2
    val f2: Int => Double = i => 2.1 * i
    val fc = f2 compose f1
    println(s"f1(3)=${f1(3)}")
    println(s"f2(6)=${f2(6)}")
    println(s"fc(3)=${fc(3)}")

    println("<==test1")
  }

  test1()
  println("<==PCompose")
}
