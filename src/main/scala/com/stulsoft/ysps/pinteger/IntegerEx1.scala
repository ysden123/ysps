/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.ysps.pinteger

/**
  * @author Yuriy Stul
  */
object IntegerEx1 extends App {
  test()

  def test(): Unit = {
    var i1: Integer = null
    if (i1 == null)
      println("null")
    else
      i1 += 1
    println(i1)
  }
}
