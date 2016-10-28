package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}

/**
  * Created by Yuriy Stul on 10/28/2016.
  */
object FutureWithException extends App with LazyLogging {
  logger.info("Start")

  def test1(): Unit = {
    logger.info("Start")
    def worker(throwException: Boolean): Future[String] = Future {
      logger.info("Start, throwException is {}", throwException)
      Thread.sleep(500)
      if (throwException) {
        logger.info("Throw exception")
        throw new Exception("test exception")
      }
      else {
        logger.info("End")
        "Good job!"
      }
    }

    def resultAnalyzer(result: Option[Try[String]], id: Int): Unit = {
      result.get match {
        case Success(s) => logger.info(s"result$id: $s")

        case Failure(e) => logger.error(s"""result$id: exception with text "${e.getMessage}"""")
      }
    }

    val result1 = Await.result(worker(false), 5.seconds)
    logger.info("result1: {}", result1)

    /** *********************************
      * Throws non-catched exception!
      * val result2 = Await.result(worker(true), 5.seconds)
      *logger.info("result2: {}", result2)
      * ***********************************/

    val result3 = Await.ready(worker(false), 5.seconds).value
    resultAnalyzer(result3, 3)

    val result4 = Await.ready(worker(true), 5.seconds).value
    resultAnalyzer(result4, 4)
  }

  test1()
  logger.info("End")
}
