/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pscala_java_types

import java.util.concurrent.TimeUnit

/**
  * Playing with Java/Scala types
  *
  * Demonstrates performance difference between usage of Scala and Java Double.
  *
  * @author Yuriy Stul
  */
object BenchmarkEx01 extends App {
  private def scalaDouble(): Unit = {
    println("==>scalaDouble")
    val start = System.nanoTime
    var dResult: Double = 0.0
    (1.0 to 20000.0 by 1.3).foreach(d => {
      val dd: Double = 1.23 * d
      dResult = dResult + dd
    })
    val end = System.nanoTime
    println(s"dResult = $dResult, duration = ${TimeUnit.NANOSECONDS.toMillis(end - start)} ms")
    println("<==scalaDouble")
  }

  private def javaDouble(): Unit = {
    println("==>javaDouble")
    val start = System.nanoTime
    var dResult: java.lang.Double = 0.0
    (1.0 to 20000.0 by 1.3).foreach(d => {
      val dd: java.lang.Double = 1.23 * d
      dResult = dResult + dd
    })
    val end = System.nanoTime
    println(s"dResult = $dResult, duration = ${TimeUnit.NANOSECONDS.toMillis(end - start)} ms")
    println("<==javaDouble")
  }

  println("==>main")
  scalaDouble()
  javaDouble()
  println("<==main")

}
