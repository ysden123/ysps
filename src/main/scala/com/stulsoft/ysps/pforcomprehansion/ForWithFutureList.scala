/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pforcomprehansion

import scala.collection.mutable.ListBuffer
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * @author Yuriy Stul
  */
object ForWithFutureList extends App {
  implicit val ec: scala.concurrent.ExecutionContext = scala.concurrent.ExecutionContext.global
  val futureList = generateList()
  println(s"futureList: $futureList")

  val sl1 = for (i <- futureList) yield i
  println(s"sl1: $sl1")

  val sl2 = for (i <- futureList.flatMap(x => x.value)) yield i
  println(s"sl2: $sl2")

  val sl3 = for (
    i1 <- futureList.flatMap(x => x.value);
    i <- i1 match {
      case Success(l) => l
      case Failure(_) => List.empty
    }
  ) yield i
  println(s"sl3: $sl3")
  val sum = sl3.sum
  println(s"sum: $sum")

  val sl4 = for(
    i1 <- futureList;
    i2 <- i1.value
  )yield i2
  println(s"sl4: $sl4")

  def generateList(): ListBuffer[Future[Iterable[Long]]] = {
    val futureList = ListBuffer[Future[Iterable[Long]]]()

    val l1 = List(1L, 2L, 3L)
    val l2 = List(4L, 5L, 6L)

    val f1 = Future.successful(l1)
    val f2 = Future.successful(l2)
    val f3 = Future.failed(new RuntimeException("Test exception"))

    futureList += f1
    futureList += f2
    futureList += f3
    futureList
  }
}
