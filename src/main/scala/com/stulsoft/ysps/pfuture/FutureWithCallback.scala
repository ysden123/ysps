package com.stulsoft.ysps.pfuture

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

/**
  * Created by Yuriy Stul on 10/8/2016.
  */
object FutureWithCallback extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    def sum = Future {
      println(s"We are inside sum. Thread ID = ${Thread.currentThread.getId}")
      (1L to 100000L).sum
    }

    sum.onSuccess {
      case s => println(s"completed sum with $s")
    }

    val sAsList = sum

    val result = Await.result(sAsList, 2.seconds)

    val extractedResult = sAsList.value.get.get

    println(s"extractedResult=$extractedResult")

    println(s"result = $result")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    def f = Future {
      Thread.sleep(500)
      42
    }
    f.onSuccess({
      case v => println(s"Succeeded with $v!")
    })

    f.onComplete({
      case Success(v) => println(s"Successfully completed with value $v")
      case Failure(e) => println(s"Failed with error $e")
    })

    f
    Thread.sleep(650)
    println("<==test2")
  }
}
