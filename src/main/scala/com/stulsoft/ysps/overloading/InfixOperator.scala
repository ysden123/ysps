/*
 * Copyright (c) 2017. Yuriy Stul 
 */

package com.stulsoft.ysps.overloading

/**
  * Playing with infix operators
  *
  * @see [[https://habrahabr.ru/company/golovachcourses/blog/255631/ Habrahabr]]
  * @author Yuriy Stul
  */
object InfixOperator extends App {
  println("==>main")
  // normal operator
  val x0 = I(1).add(I(1))
  // infix operator
  val x1 = I(1) add I(1)
  println(s"x0=$x0, x1=$x1")

  val x2 = I(1).+(I(1))
  val x3 = I(1) + I(1)
  println(s"x2=$x2, x3=$x3")
  println("<==main")

  case class I(k: Int) {
    def add(that: I): I = I(this.k + that.k)

    def +(that: I): I = I(this.k + that.k)
  }

}
