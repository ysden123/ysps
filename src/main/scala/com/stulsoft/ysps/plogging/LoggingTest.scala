package com.stulsoft.ysps.plogging

import com.typesafe.scalalogging.LazyLogging

/**
  * Created by Yuriy Stul on 10/15/2016.
  */
object LoggingTest extends App with LazyLogging {
  println("==>start")
  logger.info("Logging test")
  logger.debug("Logging test")
  println("==>finish")
}
