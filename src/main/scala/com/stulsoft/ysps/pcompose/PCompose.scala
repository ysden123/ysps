/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.pcompose

/**
  * Playing with compose
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

  /**
    * Usage compose function of the List class
    */
  private def test2(): Unit = {
    println("==>test2")
    val f1: Int => Int = i => i * 2
    val l1 = List(10, 20, 30, 40, 50, 60)

    /**
      * fc1 is the function: l1(f1(i)) - returns an element
      * with index that is equal value of f1(i). It is equal to l1.apply(f1(i))
      */
    val fc1 = l1.compose(f1)
    println(s"l1: ${l1.mkString(", ")}")
    println(s"fc1(1)=${fc1(1)}; l1(2)=${l1(2)}")
    println(s"fc1(2)=${fc1(2)}; l1(4)=${l1(4)}")
    println(s"l1.apply(4)=${l1.apply(4)}")

    println("<==test2")
  }

  test1()
  println()
  test2()
  println("<==PCompose")
}
