/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pclass

import com.typesafe.scalalogging.LazyLogging

/**
  * Created by Yuriy Stul on 11/7/2016.
  */
object ContainerTest extends App with LazyLogging {
//  val c1 = new Container(3)
//  logger.info("{}", c1.p1)
  val c2 = Container(3)
  logger.info("c2.p1 = {}", c2.p1)
}
