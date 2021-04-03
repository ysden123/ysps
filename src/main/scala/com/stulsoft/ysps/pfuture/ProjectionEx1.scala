/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.ysps.pfuture

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/** Playing with projection.
 *
 * @see [[https://docs.scala-lang.org/overviews/core/futures.html#projections]] for more information
 * @author Yuriy Stul
 */
object ProjectionEx1 extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    val f = Future {
      2 / 0
    }
    Thread.sleep(500)
    for (exc <- f.failed) println(exc)
    f.foreach(result => println(s"result = $result"))
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val f = Future {
      4 / 2
    }
    Thread.sleep(500)
    for (exc <- f.failed) println(exc)
    f.foreach(result => println(s"result = $result"))
    println("<==test2")
  }
}
