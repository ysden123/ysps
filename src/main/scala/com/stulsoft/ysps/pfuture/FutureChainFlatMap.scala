/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
  * Demonstrates Future chain using flatMap
  * Created by Yuriy Stul on 10/29/2016.
  */
object FutureChainFlatMap extends App with LazyLogging {
  logger.info("Start")

  // 1st future
  val f1 = Future {
    Thread.sleep(500)
    "F1"
  }

  // 2nd future. Waits completion of the 1st future
  val f2 = f1.flatMap {
    theF1 =>
      Future {
        Thread.sleep(500)
        s"$theF1 + 2"
      }
  }

  // 3rd future. Waits completion of the 2nd future
  val f3 = f2.flatMap {
    theF2 =>
      Future {
        Thread.sleep(500)
        theF2 + " + 3"
      }
  }

  f3 onComplete  {
    completedResult => logger.info("Completed result {}", completedResult) // result is "F1 + 2 + 3"
  }

  Thread.sleep(1600)

  logger.info("End")
}
