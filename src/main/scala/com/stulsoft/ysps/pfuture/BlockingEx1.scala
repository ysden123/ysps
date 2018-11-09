/*
 * Copyright (c) 2018. Yuriy Stul 
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, _}

/**
  * @author Yuriy Stul
  */
object BlockingEx1 extends App with LazyLogging {
  test1()
  Thread.sleep(500)

  test2()
  Thread.sleep(500)

  def test1(): Unit = {
    logger.info("==>test1")
    Future {
      Thread.sleep(100)
      logger.info("In test1")
      Thread.sleep(100)
    }
    logger.info("<==test1")
  }

  def test2(): Unit = {
    logger.info("==>test2")
    Future {
      blocking {
        Thread.sleep(100)
        logger.info("In test2")
        Thread.sleep(100)
      }
    }
    logger.info("<==test2")
  }

}
