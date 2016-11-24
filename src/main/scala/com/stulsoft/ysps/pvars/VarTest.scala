/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.pvars

/**
  * Created by Yuriy Stul on 11/22/2016.
  */
object VarTest extends App {
  println("==>main")
  var t: Int = _
  println(s"(0) t = $t")
  t = 1
  println(s"(1) t = $t")
  t = 2
  println(s"(2) t = $t")

  println("<==main")
}
