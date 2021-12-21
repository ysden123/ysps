/*
 * Copyright (c) 2021. Webpals
 */

package com.stulsoft.ysps.pexception

/**
 * @author Yuriy Stul
 */
object DivideZero extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    try {
      val x = 1.0
      val y = 1.0
      val z = 1.0 / (x - y)
      if (z.isInfinity)
        println("Infinity")
      if (z.isNaN)
        println("NaN")
      println(s"z=$z")
    } catch {
      case exception: Exception =>
        exception.printStackTrace()
    }
  }
}
