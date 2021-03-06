package com.stulsoft.ysps.pmeasure

import com.typesafe.scalalogging.LazyLogging

/**
  * @author Yuriy Stul.
  *         Created on 11/9/2016.
  */
object MeasureBlock extends App with LazyLogging {
  logger.info("Start")
  val x = 1000

  def measureTime[T](block: => T) = {
    val startTime = System.nanoTime()
    val result = block
    val endTime = System.nanoTime()
    logger.info("Measured time (ns): " + (endTime - startTime))
    result
  }
  logger.info("measureTime({ x*x*x }: {}", measureTime({ x*x*x }))
  logger.info("measureTime(Math.sin(x)): {}", measureTime(Math.sin(x)))


  logger.info("End")
}
