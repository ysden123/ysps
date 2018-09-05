/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.precondition

import com.typesafe.scalalogging.LazyLogging

/** Playing with preconditions: ensuring
  *
  * @author Yuriy Stul
  */
object EnsuringEx1 extends App with LazyLogging {
  logger.info("==>")

  private def makePositiveResult = 17

  private def makeNegativeResult = -17

  val r1 = makePositiveResult ensuring (_ > 0)

  try {
    val r2 = makeNegativeResult ensuring (_ > 0)
  } catch {
    case e: AssertionError => logger.error("makeNegativeResult: {}", e.getMessage)
    //    case e: Exception => logger.error(e.getMessage, e)
  }

  logger.info("<==")
}
