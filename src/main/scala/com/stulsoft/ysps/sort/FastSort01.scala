/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.sort

import scala.util.Random

/**
  * Fast sort
  *
  * @author Yuriy Stul
  */
object FastSort01 extends App {

  def sort(xs: Array[Int]): Array[Int] = {
    if (xs.length <= 1) xs
    else {
      val pivot = xs(xs.length / 2)
      Array.concat(
        sort(xs filter (pivot >)),
        xs filter (pivot ==),
        sort(xs filter (pivot <)))
    }
  }

  println("==>main")
    var r = Random
    val data = (1 to 100000)
      //  val data = (1 to 10)
      .map(i => r.nextInt())
      .toArray
    val sortedData = sort(data)

  //  println(s"""sorted: ${sortedData.mkString(", ")}""")
  println("<==main")
}
