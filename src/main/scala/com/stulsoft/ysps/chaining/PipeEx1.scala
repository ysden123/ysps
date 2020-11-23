/*
 * Copyright (c) 2020. StulSoft
 */

package com.stulsoft.ysps.chaining

import scala.util.chaining.scalaUtilChainingOps

/**
  * @author Yuriy Stul
  */
object PipeEx1 extends App {
  def f1(s: String): Int = {
    s.length
  }

  def f2(i: Int): String = {
    s"i = $i"
  }

  val s = "abcd"
  val result = s.pipe(f1).pipe(f2)
  println(s"result is $result")
}
