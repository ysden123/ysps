/*
 * Copyright (c) 2020. Yuriy Stul 
 */

package com.stulsoft.ysps.pcollection

import com.typesafe.scalalogging.StrictLogging

/**
  * @author Yuriy Stul
  */
object PGroupBy extends App with StrictLogging {
  val l1 = List(SomeObjectForGrouping("y", 1), SomeObjectForGrouping("y1", 1), SomeObjectForGrouping("o", 2))
  logger.info("Result: {}", l1.groupBy(_.age).toList)
}

case class SomeObjectForGrouping(name: String, age: Int)
