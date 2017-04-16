/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pgenerics

import scala.reflect.ClassTag

/**
  * Generic creator
  *
  * @author Yuriy Stul
  */
object CreatorEx01 extends App {

  val c01 = new C01("Test")

  println("==>main")
  val l01 = c01.generateList()
  val m = Array.ofDim[String](2, 2)
  println(s"l01: $l01")
  val m01 = c01.generateMatrix(m)
  m(0)(0) = "test"

  class C01[T: ClassTag](x: T) {

    def generateList(): List[T] = {
      List[T]()
    }

    def generateMatrix(x: Array[Array[T]]): Array[Array[T]] = {
      val m = Array.ofDim[T](2, 2)
      m(0)(0) = x(0)(0)
      m
    }
  }
  println(s"m01: $m01, m01.length = ${m01.length}, m01(0).length = ${m01(0).length}, m01(0)(0)=${m01(0)(0)}")
  println("<==main")
}
