/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success}

/**
  * Demonstrates usage Future with "andThen"
  *
  * Created by Yuriy Stul on 10/30/2016.
  */
object FutureWithAndThen extends App with LazyLogging {
  def test1(): Unit = {
    logger.info("Start")

    val f = Future {
      5
    }

    f andThen {
      case _ => logger.info("Side-effecting actions ...")
    } andThen {
      case Failure(t) => logger.error("Error: {}", t)
      case Success(v) => logger.info("Result: {}", v)
    }

    Thread.sleep(100)

    logger.info("End")
  }

  def test2(): Unit = {
    logger.info("Start")

    val f = Future {
      Thread.sleep(500)
      5
    }

    f andThen {
      case _ => logger.info("Side-effecting actions ...")
    } andThen {
      case Failure(t) => logger.error("Error: {}", t)
      case Success(v) => logger.info("Result: {}", v)
    }

    Thread.sleep(1000)

    logger.info("End")
  }

  test1()
  test2()
}
