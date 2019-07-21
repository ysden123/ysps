package com.stulsoft.ysps.pcollection

import java.util.concurrent.TimeUnit
import scala.collection.parallel.CollectionConverters._

/** Playing with reduce in parallel
  *
  * Using without parallel and with parallel.
  *
  * Conclusion: if we want to use reduce with parallel the function in reduce should be associative.
  *
  * For instance  {{{(v1,v2)->v1 + v2}}} is good function (associative) and {{{(v1,v2)->v1 - v2}}} is bad function (non-associative)
  *
  * @author Yuriy Stul.
  */
object ReduceParallel01 extends App {
  val N = 100000
  List(test1(),
    test2(),
    test3(),
    test4(),
    test5(),
  ).sortBy(r => r.duration)
    .foreach(println)


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

  /**
    * With parallel and minus
    */
  def test5(): Result = {
    println("==>test5")
    val start = System.nanoTime()
    val result = -(0 to N)
      .par
      .reduce((a1, a2) => a1 + a2)
    val end = System.nanoTime()
    println("<==test5")
    Result(TimeUnit.NANOSECONDS.toMillis(end - start), "With parallel and minus", result)
  }
}

case class Result(duration: Long, text: String, value: Int)