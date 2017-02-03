/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.types

/**
  * Playing with types. View bounds ("type classes")
  *
  * View bounds are deprecated.
  *
  * @see [[https://twitter.github.io/scala_school/advanced-types.html Advanced types]]
  * @author Yuriy Stul
  */
object ViewBoundsEx01 extends App {
  /*Implicit functions allow automatic conversion*/
  implicit private def strToInt(x: String) = x.toInt

  println("==>main")
  println("123")
  val y: Int = "123"
  println(s"y = $y")
  println(s"""math.max("123s", 111): ${math.max("123", 111)}""")
  println("<==main")
}
