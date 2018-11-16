/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul
  */
object POptionInitializing extends App {
  val o1 = Option("text")
  println(s"o1=$o1")

  val o2 = Option.empty[Long]
  println(s"o2=$o2")

  val o3:Option[String] = Some("text")
  println(s"o3=$o3")

  val o4:Option[String] = None
  println(s"o4=$o4")
}
