package com.stulsoft.ysps.pfuture

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * @author Yuriy Stul.
  */
object FutureEx1 extends App {
  test1()
  test2()

  def test1(): Unit = {
    def f1(): Future[String] = Future {
      "test1"
    }

    val f11 = f1()
    println(Await.result(f11, Duration.Inf))
  }

  def test2(): Unit = {
    val f1: Future[String] = Future {
      "test2"
    }

    val f11 = f1
    println(Await.result(f11, Duration.Inf))

    val f2: Future[String] = Future {
      "test22"
    }
    println(Await.result(f2, Duration.Inf))

    println("before f3")
    val f3: String => Future[String] = (s) => Future {
      println("in f3")
      s + "test23"
    }
    println("after f3")
    println(Await.result(f3("for f3"), Duration.Inf))

    println("before f4")
    val f4 = Future {
      println("in f4")
      "test 4"
    }
    println("after f4")
    println(Await.result(f4, Duration.Inf))
  }

}
