/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.ysps.pright

import com.typesafe.scalalogging.StrictLogging

/**
  * @author Yuriy Stul
  */
object RightEx1 extends App with StrictLogging {
  logger.info("==>main")

  test1()

  def test1(): Unit = {
    logger.info("==>test1")
    val right = Right(123)
    logger.debug("right: {}", right)
    logger.debug("right.isLeft: {}", right.isLeft)
    logger.debug("right.isRight: {}", right.isRight)
    logger.debug("right.exists(x => 123 == x) = {}",right.exists(x => 123 == x))
    var result = right.filterOrElse(x => x > 12, "Not found")
    logger.debug("result = {}", result)
    result = right.filterOrElse(x => x > 123, "Not found")
    logger.debug("result = {}", result)
  }
}
