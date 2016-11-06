/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pconf

import com.typesafe.config._
import com.typesafe.scalalogging.LazyLogging

/**
  * Demonstrates usage Typesafe's configuration API.
  *
  * Created by Yuriy Stul on 11/6/2016.
  */
object Conf1 extends App with LazyLogging {
  logger.info("Start")

  val conf1 = ConfigFactory.load("conf1.conf").getConfig("conf1")
  logger.info("conf1.getString(\"param1\"): {}", conf1.getString("param1"))
  logger.info("conf1.getString(\"develop.url\"): {}", conf1.getString("develop.url"))
  logger.info("conf1.getString(\"develop.maxNum\"): {}", conf1.getString("develop.maxNum"))
  logger.info("conf1.getString(\"systest.url\"): {}", conf1.getString("systest.url"))
  logger.info("conf1.getString(\"systest.maxNum\"): {}", conf1.getString("systest.maxNum"))

  val develop = conf1.getConfig("develop")
  logger.info("develop.getString(\"url\"): {}", develop.getString("url"))
  logger.info("develop.getString(\"maxNum\"): {}", develop.getString("maxNum"))

  val systest = conf1.getConfig("systest")
  logger.info("systest.getString(\"url\"): {}", systest.getString("url"))
  logger.info("systest.getString(\"maxNum\"): {}", systest.getString("maxNum"))

  logger.info("End")
}
