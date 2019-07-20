/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}

/**
  * @author Yuriy Stul
  */
object FutureWithAndThen2 extends App with LazyLogging {
  logger.info("==>FutureWithAndThen2")

  wrongTest()
  goodTest()
  correctChain()

  /**
    * "finish" is going before f2 stated
    */
  def wrongTest(): Unit = {
    logger.info("==>wrongTest")
    val result = f1()
      .andThen { case _ => f2() }
      .andThen { case _ => logger.info("(1) finish") }

    Await.result(result, Duration.Inf)

    Thread.sleep(1000)

    logger.info("<==wrongTest")
  }

  /**
    * "finish" is going after f2 finished
    */
  def goodTest(): Unit = {
    logger.info("==>goodTest")
    val result = f1()
      .andThen { case _ => f2().andThen { case _ => logger.info("(2) finish") } }

    Await.result(result, Duration.Inf)

    Thread.sleep(1000)

    logger.info("<==goodTest")
  }

  def f1(): Future[Unit] = Future {
    logger.info("==>f1")
    Thread.sleep(2000)
    logger.info("<==f1")
  }

  def f2(): Future[Unit] = Future {
    logger.info("==>f2")
    Thread.sleep(1000)
    logger.info("<==f2")
  }

  /**
    * Correct chain of futures
    */
  def correctChain(): Unit = {
    logger.info("==>correctChain")
    val result = for {
      _ <- f1()
      _ <- f2()
      _ <- Future {
        logger.info("(3) finish")
      }
    } yield ()
    Await.result(result, Duration.Inf)
    logger.info("<==correctChain")
  }

  logger.info("<==FutureWithAndThen2")
}
