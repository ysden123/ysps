/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pimlicit

import com.typesafe.scalalogging.LazyLogging

/**
  * Demonstrates implicit with implicit field
  *
  * @see See [[http://alvinalexander.com/scala/scala-implicit-method-arguments-fields-example]]
  *
  *      Created by Yuriy Stul on 11/8/2016.
  */
object ImplicitMethod extends App with LazyLogging {
  logger.info("Start")

  def yo(implicit s: String) = logger.info("Yo, " + s)

  yo("Yuriy")

  implicit val fred = "Fred"
  yo

  def add(implicit s: Int) = logger.info("{}", s + 1)

  add(3)

  implicit val four = 4
  add

  // ERROR: ambiguous implicit values: four and five
  //  implicit val five = 5
  //  add

  logger.info("End")
}
