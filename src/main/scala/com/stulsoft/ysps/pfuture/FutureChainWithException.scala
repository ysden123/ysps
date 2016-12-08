/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Created by Yuriy Stul on 10/29/2016.
  */
object FutureChainWithException extends App with LazyLogging {
  logger.info("Start")
  // 1st future
  val f1 = Future {
    Thread.sleep(500)
    "F1"
  }

  // 2nd future. Waits completion of the 1st future
  // Throws exception
  val f2: Future[String] = f1.flatMap {
    _ =>
      Future {
        Thread.sleep(500)
        //        s"$theF1 + 2"
        throw new Exception("""f2 "failed".""")
      }
  }

  // 2nd future. Waits completion of the 1st future
  val f3 = f2.flatMap {
    theF2 =>
      Future {
        Thread.sleep(500)
        theF2 + "+ 3"
      }
  }

  f3 foreach {
    result => logger.info("Completed result {}", result)
  }
  f3.onComplete {
    case Success(s) => logger.info("Success: {}",s)
    case Failure(e) => logger.error("(1) Failure {}", e.getMessage)
  }

  f3.failed.foreach(e => logger.error("(2) Failure {}", e.getMessage))

  Thread.sleep(1600)

  logger.info("End")
}
