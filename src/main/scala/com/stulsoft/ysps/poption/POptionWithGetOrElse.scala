/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul
  */
object POptionWithGetOrElse extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")

    val o1: Option[Long] = Some(1)
    val r1 = o1.getOrElse(2) // 2 is the default value
    println(s"o1 = $o1, r1 = $r1")

    val o2: Option[Long] = None
    val r2 = o2.getOrElse(2) // 2 is the default value
    println(s"o2 = $o2, r2 = $r2")
    println("<==test1")
  }
}
