/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul
  */
object POption8 extends App {
  val v1 = Option("text").map(s => s)
  val v11:Option[String] = Option("text").map(s => s)
  val v2 = Option.empty[String].map(s => s)
  val v21:Option[String] = Option.empty[String].map(s => s)

  println(s"v1 = $v1")
  println(s"v11 = $v11")
  println(s"v2 = $v2")
  println(s"v21 = $v21")
}
