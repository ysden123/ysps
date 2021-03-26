/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pimplicit

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

  private def yo(implicit s: String): Unit = logger.info("Yo, " + s)

  yo("Yuriy")

  implicit val fred: String = "Fred"
  yo

  private def add(implicit s: Int): Unit = logger.info("{}", s + 1)

  add(3)

  implicit val four: Int = 4
  add

  // ERROR: ambiguous implicit values: four and five
  //  implicit val five = 5
  //  add

  logger.info("End")
}
