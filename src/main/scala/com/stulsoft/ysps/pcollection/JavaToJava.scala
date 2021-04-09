/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.ysps.pcollection

import java.util

import scala.jdk.CollectionConverters._

/**
  * @author Yuriy Stul
  * @since 2/19/2018
  */
object JavaToJava extends App {
  def transform1(input: util.List[String]): util.List[String] = {
    input.asScala.map(_.substring(1)).toList.asJava
  }

  println(transform1(util.Arrays.asList("123", "456", "789")))
}
