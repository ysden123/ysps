/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.ppartialfunction

/**
  * @author Yuriy Stul
  */
object PartialFunctionEx2 extends App {
  testValFunction()
  testDefFunction()

  def testValFunction(): Unit = {
    println("==>testValFunction")
    val squareRoot: PartialFunction[Double, Double] = {
      case d: Double if d > 0 => Math.sqrt(d)
    }

    println(s"squareRoot(4) = ${squareRoot(4)}")

    try {
      println(s"squareRoot(-4) = ${squareRoot(-4)}")
    } catch {
      case e: Exception => println(s"squareRoot(-4) --> Error: ${e.getMessage}")
    }

    val l = List(4.0, 9.0, -9.0)
    println(s"l: $l")
    println(s"l.collect(squareRoot): ${l.collect(squareRoot)}")

    println(s"squareRoot.isDefinedAt(1): ${squareRoot.isDefinedAt(1)}")
    println(s"squareRoot.isDefinedAt(-1): ${squareRoot.isDefinedAt(-1)}")

  }

  def testDefFunction(): Unit = {
    println("==>testDefFunction")

    def squareRoot: PartialFunction[Double, Double] = new PartialFunction[Double, Double] {
      override def isDefinedAt(x: Double): Boolean = x > 0

      override def apply(x: Double): Double = Math.sqrt(x)
    }

    println(s"squareRoot(4) = ${squareRoot(4)}")

    try {
      println(s"squareRoot(-4) = ${squareRoot(-4)}")
    } catch {
      case e: Exception => println(s"squareRoot(-4) --> Error: ${e.getMessage}")
    }

    val l = List(4.0, 9.0, -9.0)
    println(s"l: $l")
    println(s"l.collect(squareRoot): ${l.collect(squareRoot)}")

    println(s"squareRoot.isDefinedAt(1): ${squareRoot.isDefinedAt(1)}")
    println(s"squareRoot.isDefinedAt(-1): ${squareRoot.isDefinedAt(-1)}")
  }
}
