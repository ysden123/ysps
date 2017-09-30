/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pfor

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Success

/** Demonstrates usage comprehension ''for'' and ''flatMap'' with ''Future''
  *
  * @author Yuriy Stul
  */
object ForWithFuture extends App {
  test1()
  test2()

  /**
    * ''Future'' with comprehension ''for''
    */
  def test1(): Unit = {
    println("==>test1")
    val f = for {
      job1 <- job1()
      _ = println(s"Received job1: $job1")
      job2 <- job2(job1)
      _ = println(s"Received job2: $job2")
    } yield {}
    Await.ready(f, Duration.Inf)
    println("<==test1")
  }

  def job1(): Future[String] = Future {
    println("==>job1")
    Thread.sleep(500)
    println("<==job1")
    "The job1 result"
  }

  def job2(param: String): Future[String] = Future {
    println("==>job2")
    Thread.sleep(500)
    println("<==job2")
    "The job2 with " + param
  }

  /**
    * ''Future'' with ''flatMap''
    */
  def test2(): Unit = {
    println("==>test2")
    val f = job1().flatMap {
      job1Result =>
        println(s"job1Result: $job1Result")
        job2(job1Result) andThen {
          case Success(job2Result) => println(s"job2Result: $job2Result")
        }
    }

    Await.ready(f, Duration.Inf)
    println("<==test2")
  }
}
