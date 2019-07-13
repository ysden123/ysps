/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.precursion

import com.typesafe.scalalogging.LazyLogging

import scala.annotation.tailrec

/** Fibonacci algorithm
  *
  * @author Yuriy Stul
  */
object Fibonacci extends App with LazyLogging {
  (0 to 10).foreach(x => logger.info(s"fibonacci($x) = ${fibonacci(x)}"))

  def fibonacci(x: Int): BigInt = {
    @tailrec def fibHelper(x: Int, prev: BigInt = 0, next: BigInt = 1): BigInt = x match {
      case 0 => prev
      case 1 => next
      case _ => fibHelper(x - 1, next, next + prev)
    }

    fibHelper(x)
  }
}
