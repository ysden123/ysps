/*
 * Copyright (c) 2020. StulSoft
 */

package com.stulsoft.ysps.chaining

import scala.util.chaining.scalaUtilChainingOps

/**
  * @author Yuriy Stul
  */
object TapEx1 extends App {
  def f1(s: String): Int = {
    s.length
  }

  def f2(i:Int): Unit ={
        println(s"side effect for i = $i")
  }

  val s = "abcd"
  val result = f1(s).tap(f2)
  println(s"result = $result")
}
