package com.stulsoft.ysps.pfuture

import scala.collection.mutable
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * @author Yuriy Stul
  */
object FutureEx2 extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  val listOfFutures = new mutable.ArrayBuffer[Future[Unit]]()
  val f1 = Future {
    println("==>f1")
    Thread.sleep(1000)
  }
  listOfFutures += f1

  val f2 = Future {
    println("==>f2")
    Thread.sleep(1500)
  }
  listOfFutures += f2
  listOfFutures.foreach(Await.result(_, Duration.Inf))
  println("Done")
}
