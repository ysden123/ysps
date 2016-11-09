package com.stulsoft.ysps.measure

import com.typesafe.scalalogging.LazyLogging

/**
  * @author Yuriy Stul.
  *         Created on 11/9/2016.
  */
object MeasureBlock extends App with LazyLogging {
  logger.info("Start")
  def measureTime[RESULT](block: => RESULT) = {
    val startTime = System.nanoTime()
    val result = block
    val endTime = System.nanoTime()
    logger.info("Measured time (ns): " + (endTime - startTime))
    result
  }
  val x = 1000
  logger.info("measureTime({ x*x*x }: {}", measureTime({ x*x*x }))
  logger.info("measureTime(Math.sin(x)): {}", measureTime(Math.sin(x)))


  logger.info("End")
}
