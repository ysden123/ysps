/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pimlicit

import com.stulsoft.ysps.pimlicit.StringUtils._
import com.typesafe.scalalogging.LazyLogging

/**
  * Created by Yuriy Stul on 11/8/2016.
  */
object ImplicitClassTest extends App with LazyLogging {
  logger.info("Start")
  logger.info(""""Hey".increment: {}""", "Hey".increment)
  logger.info("End")
}
