/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pcollection

/**
  * Playing with grouped
  *
  * @author Yuriy Stul
  */
object PGrouped extends App {
  val c1 = Seq(1, 2, 3, 4, 5, 6, 7)
  val c2 = c1.grouped(5).toList
  println(s"c1: $c1, c2: $c2")
}
