package com.stulsoft.ysps.pcollection

import java.util.concurrent.TimeUnit

/** Playing with reduce in parallel
  *
  * @author Yuriy Stul.
  */
object ReduceParallel01 extends App {
  val N = 100000
  List(test1(),
    test2(),
    test3(),
    test4(),
  ).foreach(println)


  /**
    * Without parallel
    */
  def test1(): Result = {
    println("==>test1")
    val start = System.nanoTime()
    val result = (0 to N).reduce((a1, a2) => a1 - a2)
    val end = System.nanoTime()
    println("<==test1")
    Result(TimeUnit.NANOSECONDS.toMillis(end - start), "Without parallel", result)
  }

  /**
    * With parallel
    */
  def test2(): Result = {
    println("==>test2")
    val start = System.nanoTime()
    val result = (0 to N)
      .par
      .reduce((a1, a2) => a1 - a2)
    val end = System.nanoTime()
    println("<==test2")
    Result(TimeUnit.NANOSECONDS.toMillis(end - start), "With parallel", result)
  }

  /**
    * With sum and without parallel
    */
  def test3(): Result = {
    println("==>test3")
    val start = System.nanoTime()
    val result = -(0 to N).sum
    val end = System.nanoTime()
    println("<==test3")
    Result(TimeUnit.NANOSECONDS.toMillis(end - start), "With sum and without parallel", result)
  }

  /**
    * With sum and with parallel
    */
  def test4(): Result = {
    println("==>test4")
    val start = System.nanoTime()
    val result = -(0 to N).par.sum
    val end = System.nanoTime()
    println("<==test4")
    Result(TimeUnit.NANOSECONDS.toMillis(end - start), "With sum and with parallel", result)
  }
}

case class Result(duration: Long, text: String, value: Int)