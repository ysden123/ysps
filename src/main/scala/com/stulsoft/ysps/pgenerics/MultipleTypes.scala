package com.stulsoft.ysps.pgenerics

/**
  * Playing with multiple types in generics.
  *
  * <p>
  * Usage the <i>type</i>
  *
  * @author Yuriy Stul.
  */
object MultipleTypes extends App {
  type NumberType = (Double, Int, Long, Float) => Number

  def f(x: Number): Unit = {
    println(s"x = $x")
  }

  println("==>main")
  f(1)
  f(2.0)
  f(3.0E-1)
  f(4L)
  // Error: type mismatch
//  f("text")
  println("<==main")
}
