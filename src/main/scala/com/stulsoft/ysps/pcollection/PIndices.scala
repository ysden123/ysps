/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pcollection

/**
  * Playing with indices.
  *
  * @author Yuriy Stul
  */
object PIndices extends App {
  def t1(): Unit = {
    println("==>t1")
    val p = Seq((1, 1), (2, 2), (3, 3))
    p.indices.foreach(println)
    println("<==t1")
  }

  def t2(): Unit = {
    println("==>t2")
    val p = Seq((1, 1), (2, 2), (3, 3))
    var s = 0.0
    p.indices.foreach(i => if (i > 0) s += (p(i)._2 + p(i - 1)._2))
    println(s"s=$s")
    println("<==t2")
  }

  println("==>main")
  t1()
  t2()
  println("<==main")
}
