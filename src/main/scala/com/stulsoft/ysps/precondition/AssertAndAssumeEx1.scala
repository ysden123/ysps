/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.precondition

import com.typesafe.scalalogging.LazyLogging

/** Playing with preconditions: assert and assume
  *
  * The difference between assert() and assume() is that
  *
  * - ``assert()`` is a way to document and dynamically check invariants, while
  * - ``assume()`` is intended to be consumed by static analysis tools
  *
  * The intended consumer / context of assert() is testing,
  * such as a Scala JUnit test, while that of assume()
  * is "as a means of design-by-contract style specification of pre- and post-conditions
  * on functions, with the intention that these specifications could be consumed
  * by a static analysis tool" (excerpted from the scaladoc).
  *
  * @author Yuriy Stul
  */
object AssertAndAssumeEx1 extends App with LazyLogging {
  logger.info("==>")

  private def makePositiveResult = 17

  private def makeNegativeResult = -17

  val r1 = makePositiveResult
  assert(r1 > 0)

  try {
    val r2 = makeNegativeResult
    assert(r2 > 0)
  } catch {
    case e: AssertionError => logger.error("makeNegativeResult: {}", e.getMessage)
  }

  try {
    val r3 = makeNegativeResult
    assume(r3 > 0)
  } catch {
    case e: AssertionError => logger.error("makeNegativeResult: {}", e.getMessage)
  }
  logger.info("<==")
}
