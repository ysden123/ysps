package com.stulsoft.ysps.prange

/**
  * @author Yuriy Stul.
  */
object RangeEx1 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val r = Range(1, 20, 3)
    r foreach println
    println()
    val r1 = 1 to 20 by 3
    r1 foreach println
    println("<==test1")
  }
}
