/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Demonstrates Future chain using map
  * Created by Yuriy Stul on 10/30/2016.
  */
object FutureChainMap extends App with LazyLogging {
  logger.info("Start")

  // 1st future
  val f1 = Future {
    logger.info("In f1")
    Thread.sleep(500)
    "F1"
  }

  // 2nd future. Waits completion of the 1st future
  val f2 = f1.map {
    logger.info("In f2 (0)")
    theF1 =>
      logger.info("In f2 (1)")
      Future {
        logger.info("In f2 (2)")
        Thread.sleep(500)
        s"$theF1 + 2"
      }
  }

  // 2nd future. Waits completion of the 2nd future
  val f3 = f2.map {
    logger.info("In f3 (0)")
    theF2 =>
      logger.info("In f3 (1)")
      Future {
        logger.info("In f3 (2)")
        Thread.sleep(500)
        theF2 + "+ 3"
      }
  }

  f3 onComplete  {
    completedResult =>
      logger.info("Completed result {}", completedResult) // result is List() - empty list!
      logger.info("Result value is {}", completedResult)
  }

  Thread.sleep(1600)

  logger.info("End")
}
