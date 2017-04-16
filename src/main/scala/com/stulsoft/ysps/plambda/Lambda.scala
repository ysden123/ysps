package com.stulsoft.ysps.plambda

/**
  * Created by Yuriy Stul on 9/13/2016.
  */
object Lambda {
  def main(args: Array[String]): Unit = {
    println("==>main")
    lambda1()
    println("<==main")
  }

  def lambda1(): Unit = {
    println("==>lambda1")
    val max: (Int, Int) => Int = (m: Int, n: Int) => if (m > n) m else n
    println(max(1, 2))
    println(max(3, 2))
    println("<==lambda1")
  }
}
