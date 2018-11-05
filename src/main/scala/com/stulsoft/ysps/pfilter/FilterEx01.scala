/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pfilter

/**
  * @author Yuriy Stul
  */
object FilterEx01 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val l = List[(Int, String)]((1, "one"), (2, "tow"))

    l.filter { case (i, _) => i > 1 }.foreach(println)
    println("<==test1")
  }
}
