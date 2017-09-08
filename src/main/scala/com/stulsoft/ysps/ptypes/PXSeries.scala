/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes

/** Type alias usage
  *
  * @author Yuriy Stul
  */
object PXSeries extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    // Type alias definition
    type XSeries[T] = Vector[T]

    // XSeries.apply definition
    def XSeries(xs: Double*) = Vector(xs: _*)

    def f(x: XSeries[Double]): Double = {
      x.sum
    }

    // Without usage of XSeries.apply
    val v1 = f(Vector(1.0, 2.0, 3, 4))
    // With usage of XSeries.apply
    val v2 = f(XSeries(1.0, 2.0, 3, 4))

    println(v1)
    println(v2)
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    type XSeries[T] = Vector[T]

    def XSeries[T](xs: T*) = Vector(xs: _*)

    def f(x: XSeries[Double]): Double = x.sum

    val v1 = f(XSeries(1.0, 2.0, 3, 4))
    println(v1)
    println("<==test2")
  }
}
