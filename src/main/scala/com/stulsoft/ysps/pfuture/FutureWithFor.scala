package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

/**
  * Created by Yuriy Stul on 10/27/2016.
  *
  * See original code [[http://alvinalexander.com]]
  */
object FutureWithFor extends App with LazyLogging {
  logger.info("Start")

  def sleep(time: Long): Unit = Thread.sleep(time)
  def delta(startTime:Long):Long = System.currentTimeMillis - startTime

  def slowlyDouble(x: Int, delay: Int, name: String, startTime:Long): Future[Int] = Future {
    logger.info(s"entered $name:  ${delta(startTime)}")
    sleep(delay)
    logger.info(s"leaving $name:  ${delta(startTime)}")
    x * 2
  }

  def test01(): Unit = {
    logger.info("Start")
    val startTime = System.currentTimeMillis

    // Future #1
    logger.info(s"creating f1:  ${delta(startTime)}")
    val f1 = slowlyDouble(x=1, delay=1500, name="f1", startTime=startTime)

    // Future #2
    Thread.sleep(100)
    logger.info(s"creating f2:  ${delta(startTime)}")
    val f2 = slowlyDouble(x=2, delay=250, name="f2", startTime=startTime)

    // Future #3
    Thread.sleep(100)
    logger.info(s"creating f3:  ${delta(startTime)}")
    val f3 = slowlyDouble(x=3, delay=500, name="f3", startTime=startTime)

    logger.info(s"entering `for`: ${delta(startTime)}")
    val result = for {
      r1 <- f1
      r2 <- f2
      r3 <- f3
    } yield r1 + r2 + r3

    logger.info("BEFORE onComplete")
    result.onComplete {
      case Success(x) =>
        logger.info(s"result = $x (delta = ${delta(startTime)})")
        logger.info("note that you don't get the result until the last future completes")

      case Failure(e) => e.printStackTrace()
    }
    logger.info("AFTER onComplete")

    // important for a little parallel demo: keep the jvm alive
    Await.result(result, 3.seconds)

    logger.info("End")
  }

  test01()
  logger.info("End")
}
