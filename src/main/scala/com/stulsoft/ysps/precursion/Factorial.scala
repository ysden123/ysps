/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.precursion

import scala.annotation.tailrec

/**
  * @author Yuriy Stul
  */
object Factorial extends App {

  test(5)

  /**
    * Test runner
    */
  def test(n: Int): Unit = {
    println(s"(1) n = $n -> ${factorial1(n)}")
    println(s"(2) n = $n -> ${factorial2(n)}")
  }

  /**
    * Non-tail recursion
    */
  def factorial1(n: Int): Int = n match {
    case 0 => 1
    case x => n * factorial1(x - 1)
  }

  /**
    * Tail recursion
    */
  def factorial2(n: Int): Int = {
    @tailrec
    def factorial(currentValue: Int, currentN: Int): Int = currentN match {
      case 0 => currentValue
      case x => factorial(currentValue * x, x - 1)
    }

    factorial(1, n)
  }
}
