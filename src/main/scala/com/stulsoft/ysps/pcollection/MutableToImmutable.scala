/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pcollection

import com.typesafe.scalalogging.LazyLogging


/** Converts muttable collection to immutable collection
  * @author Yuriy Stul
  */
object MutableToImmutable extends App with LazyLogging {
  test1()

  def test1(): Unit = {
    val mutableNumbers = List(1, 2, 3)
    logger.info(s"mutableNumbers: $mutableNumbers")
    val immutableNumbers: scala.collection.immutable.List[Int] = mutableNumbers
    logger.info(s"immutableNumbers: $immutableNumbers")
  }
}
