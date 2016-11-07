/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pclass

import com.typesafe.scalalogging.LazyLogging

/**
  * Created by Yuriy Stul on 11/7/2016.
  */
object Container2Test extends App with LazyLogging {
  // Error: ctor unavailable
  //  val c1 = new Container2(3)
  //  logger.info("{}", c1.p1)
  val c2 = Container2(3)
  logger.info("c2.p1 = {}", c2.p1)
  // Error: reassignment to val
  //  c2.p1 = 432
}
