/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.parantheses

import com.typesafe.scalalogging.LazyLogging

/**
  * Playing with parentheses.
  *
  * How to declare parameterless functions.
  *
  * @author Yuriy Stul
  */
object PlayingWithParentheses extends App with LazyLogging {
  var forUsingInF1: Int = 0
  logger.info("==>PlayingWithParentheses")

  /**
    * The function has side effect (changes the forUsingInF1's value)
    *
    * Although this function has no parameters it has to have parentheses to indicate a side effect
    */
  private def f1() = {
    logger.info("f1: do something")
    forUsingInF1 += 1
  }

  /**
    * The function has side effect (changes the forUsingInF1's value)
    *
    * Although this function has no parameters it has to have parentheses to indicate a side effect
    *
    * The function is public (modifier private is not used!) - return type must be specified explicitly.
    */
  def f2():Unit={
    logger.info("f2: do something")
    forUsingInF1 += 2
  }

  /**
    * The function has no parameters, has not side effect, and returns a value.
    *
    * No need to use parentheses
    *
    * @return a text
    */
  private def f3: String = {
    "Today is nice day!"
  }

  f1()
  f2()
  logger.info(f3)

  logger.info("<==PlayingWithParentheses")
}
