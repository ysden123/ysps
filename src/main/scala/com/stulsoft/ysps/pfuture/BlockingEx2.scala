/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent._

/**
  * @author Yuriy Stul
  */
object BlockingEx2 extends App with LazyLogging {
  test1()
  Thread.sleep(500)

  def test1(): Unit = {
    logger.info("==>test1")
    blocking {
      Thread.sleep(100)
      logger.info("In test1")
      Thread.sleep(100)
    }
    logger.info("<==test1")
  }

}
