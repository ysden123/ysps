/*
 * Copyright (c) 2020. StulSoft
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.StrictLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.DurationInt
import scala.concurrent.{Await, Future}

/**
  * @author Yuriy Stul
  */
object FunctionWithAwait extends App with StrictLogging {
  def f(): String = {
    logger.info("==>f")
    val futureResult = Future {
      logger.info("==>future")
      Thread.sleep(500)
      "A result text"
    }
    Await.result(futureResult, 1 seconds)
  }

  logger.info("==>main")
  logger.info(s"f(): ${f()}")
}
