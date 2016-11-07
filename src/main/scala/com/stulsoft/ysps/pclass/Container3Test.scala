/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pclass

import com.typesafe.scalalogging.LazyLogging

/**
  * Created by Yuriy Stul on 11/7/2016.
  */
object Container3Test extends App with LazyLogging {
  val c3 = Container3()
  logger.info("c3.p1 = {}", c3.p1)
}
