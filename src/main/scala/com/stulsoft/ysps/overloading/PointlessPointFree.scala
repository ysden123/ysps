/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.overloading

/**
  * Playing with pointless and point-free styles
  *
  * @see [[https://habrahabr.ru/company/golovachcourses/blog/255631/ Habrahabr]]
  * @author Yuriy Stul
  */
object PointlessPointFree extends App {
  println("==>main")
  println(f1(2))
  println(f2(2))
  println(f3(2))
  println(f4(2))
  println("<==main")

  // Non-pointless and non-point-free style
  def f1: Int => Int = x => 1.+(x)

  // Pointless and non-point-free style
  def f2: Int => Int = x => 1 + x

  // Non-pointless and point-free style
  def f3: Int => Int = 1.+

  // Pointless and point-free style
  def f4: Int => Int = 1 +
}
