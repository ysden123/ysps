/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.ysps.pforcomprehansion

import com.typesafe.scalalogging.StrictLogging

/**
 * @author Yuriy Stul
 */
object ForWithRight extends App with StrictLogging {
  test1()
  test2()

  def test1(): Unit = {
    logger.info("==>test1")
    logger.debug("1: {}", test(1))
    logger.debug("100: {}", test(100))
    logger.debug("15: {}", test(15))
  }

  def test2(): Unit = {
    logger.info("==>test2")
    logger.debug("1: {}", bear(1))
    logger.debug("100: {}", bear(100))
    logger.debug("15: {}", bear(15))
  }

  def test(param: Int): Either[String, Int] = {
    val right = Right(param)
    val result = for {
      _ <- right.filterOrElse(x => x > 12, "less than 13")
      x <- right.filterOrElse(x => x % 2 == 0, "odds")
    } yield x
    result
  }

  def bear(param: Int): Either[String, Int] = {
    val right = Right(param)
    right
      .filterOrElse(x => x > 12, "less than 13")
      .filterOrElse(x => x % 2 == 0, "odds")
  }
}
