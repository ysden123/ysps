/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.ptuple

/**
  * @author Yuriy Stul
  */
private object CompareTuple extends App {
  private def t1(): Unit = {
    println("==>t1")
    var t1 = (1.0, 2.0)
    var t2 = (1.0, 2.0)
    println(s"t1 == t2 is ${t1 == t2}")
    println(s"t1.equals(t2) is ${t1.equals(t2)}")

    t1 = (1.0, 2.0)
    t2 = (1.001, 2.0)
    println(s"t1 == t2 is ${t1 == t2}")
    println(s"t1.equals(t2) is ${t1.equals(t2)}")
    println("<==t1")
  }

  println("==>main")
  t1()
  println("<==main")
}
