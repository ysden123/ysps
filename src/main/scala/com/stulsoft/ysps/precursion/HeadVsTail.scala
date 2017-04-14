/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.precursion

import scala.annotation.tailrec

/**
  * @see [[http://alvinalexander.com/scala/scala-recursion-examples-recursive-programming Simple Scala recursion examples (recursive programming)]]
  * @author Yuriy Stul
  */
object HeadVsTail extends App {
  (1 to 5).foreach(test)

  def test(iteration: Int): Unit = {
    println(s"\nIteration $iteration")
    val list = List.range(1, 1000) // 10000 - StackOverflowError in line 422
    var start = System.nanoTime()

    println(sum1(list))
    println(s"Elapsed time: ${System.nanoTime() - start} ns")
    println()


    start = System.nanoTime()
    println(sum2(list))
    println(s"Elapsed time: ${System.nanoTime() - start} ns")
    println()

    start = System.nanoTime()
    println(sum3(list))
    println(s"Elapsed time: ${System.nanoTime() - start} ns")
    println()
  }

  /**
    * (1) yields a "java.lang.StackOverflowError" with large lists
    */
  def sum1(ints: List[Int]): Int = ints match {
    case Nil => 0
    case x :: tail => x + sum1(tail)
  }

  /**
    *
    * (2) tail-recursive solution
    */
  def sum2(ints: List[Int]): Int = {
    @tailrec
    def sumAccumulator(ints: List[Int], accum: Int): Int = {
      ints match {
        case Nil => accum
        case x :: tail => sumAccumulator(tail, accum + x)
      }
    }

    sumAccumulator(ints, 0)
  }

  /**
    * (3) good descriptions of recursion here:
    *
    * @see [[http://stackoverflow.com/questions/12496959/summing-values-in-a-list]]
    */
  def sum3(xs: List[Int]): Int = {
    if (xs.isEmpty) 0
    else xs.head + sum3(xs.tail)
  }
}
