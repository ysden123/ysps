/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.parantheses

import com.typesafe.scalalogging.LazyLogging

/**
  * Playing with braces
  *
  * @author Yuriy Stul
  */
object PlayingWithBraces extends App with LazyLogging {
  logger.info("==>PlayingWithBraces")
  val list1 = List(1, 2, 3)

  list1.map(i => i * 10).foreach(i => logger.info(s"i=$i"))
  list1.map{i => i * 20}.foreach(i => logger.info(s"i=$i"))
  list1.map((i)=>{ i * 30}).foreach(i => logger.info(s"i=$i"))

  val sum1 = list1.reduce((i1,i2)=>i1 * 5 + i2 * 6)
  logger.info(s"sum1 is $sum1")
  
  val sum2 = list1.reduce{(i1,i2)=>i1 * 5 + i2 * 6}
  logger.info(s"sum2 is $sum2")
  
  val sum3 = list1.reduce{
    (i1,i2)=>{
      logger.info(s"i1=$i1, i2=$i2")
      i1 * 5 + i2 * 6
    }
  }
  logger.info(s"sum3 is $sum3")

  logger.info("<==PlayingWithBraces")
}
