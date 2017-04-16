/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pclosure

/**
  * @author Yuriy Stul
  */
object Example1 extends App {
  /**
    * No closure usage
    */
  val belowFirst1 = (xs: List[Int]) => {

    val first = xs.head

    val isBelow = (y: Int) => y < first

    for (x <- xs; if isBelow(x)) yield x
  }

  /**
    * With closure usage (variable "offset")
    */
  val belowFirst11 = (xs: List[Int]) => {

    val first = xs.head

    val isBelow = (y: Int) => y < first + offset

    for (x <- xs; if isBelow(x)) yield x
  }

  /**
    * No closure usage
    */
  val belowFirst2 = (xs: List[Int]) => {

    val first = xs.head

    def isBelow = (y: Int) => y < first

    for (x <- xs; if isBelow(x)) yield x
  }

  /**
    * With closure usage (variable "offset")
    */
  val belowFirst21 = (xs: List[Int]) => {

    val first = xs.head

    def isBelow = (y: Int) => y < first + offset

    for (x <- xs; if isBelow(x)) yield x
  }

  /**
    * With closure usage (variable "offset")
    */
  val belowFirst22 = (xs: List[Int]) => {

    val first = xs.head

    def isBelow(y: Int): Boolean = y < first + offset

    for (x <- xs; if isBelow(x)) yield x
  }

  var offset = 3

  println("==>main")
  println(s"belowFirst1(List(5, 1, 7, 4, 9, 11, 3)): ${belowFirst1(List(5, 1, 7, 4, 9, 11, 3))}")
  println(s"belowFirst11(List(5, 1, 7, 4, 9, 11, 3)): ${belowFirst11(List(5, 1, 7, 4, 9, 11, 3))}")
  println(s"belowFirst2(List(5, 1, 7, 4, 9, 11, 3)): ${belowFirst2(List(5, 1, 7, 4, 9, 11, 3))}")
  println(s"belowFirst21(List(5, 1, 7, 4, 9, 11, 3)): ${belowFirst21(List(5, 1, 7, 4, 9, 11, 3))}")
  println(s"belowFirst22(List(5, 1, 7, 4, 9, 11, 3)): ${belowFirst22(List(5, 1, 7, 4, 9, 11, 3))}")

  offset = 1
  println(s"belowFirst11(List(5, 1, 7, 4, 9, 11, 3)): ${belowFirst11(List(5, 1, 7, 4, 9, 11, 3))}")
  println(s"belowFirst21(List(5, 1, 7, 4, 9, 11, 3)): ${belowFirst21(List(5, 1, 7, 4, 9, 11, 3))}")
  println(s"belowFirst22(List(5, 1, 7, 4, 9, 11, 3)): ${belowFirst22(List(5, 1, 7, 4, 9, 11, 3))}")

  println("<==main")
}
