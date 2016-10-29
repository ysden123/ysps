/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

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
    theF1 =>
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

  f3 onSuccess {
    case completedResult => logger.info("Completed result {}", completedResult)
  }
  f3 onFailure {
    case e => logger.error("Failure {}", e.getMessage)
  }

  Thread.sleep(1600)

  logger.info("End")

}
