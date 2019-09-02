/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.functional.programming

import scala.annotation.tailrec

/** Pure function examples with Fibonacci algorithm
  *
  * @author Yuriy Stul
  */
object FibonacciEx1 {
  def fib(n: Int): Int = {
    val f0 = 0
    val f1 = 1

    @tailrec
    def go(i: Int, fn_1: Int, fn_2: Int): Int = {
      val fn =
        if (i == 0)
          f0
        else if (i == 1)
          f1
        else
          fn_1 + fn_2
      if (i >= n)
        fn
      else
        go(i + 1, fn, fn_1)
    }

    go(0, 1, 0)
  }

  def fib2(n: Int): Int = {
    @tailrec def go(i: Int, prev: Int, next: Int): Int = {
      i match {
        case 0 => prev
        case 1 => next
        case _ => go(i - 1, next, prev + next)
      }
    }

    go(n, 0, 1)
  }

  def main(args: Array[String]): Unit = {
    (0 to 10).foreach(i => println(s"$i -> ${fib(i)} - ${fib2(i)}"))
  }
}
