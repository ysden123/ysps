/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.psort

import scala.util.Random

/**
  * Fast sort
  *
  * @author Yuriy Stul
  */
object FastSort01 extends App {

  val data = (1 to 100000)
    //  val data = (1 to 10)
    .map(i => r.nextInt())
    .toArray

  println("==>main")
  val sortedData = sort(data)
  var r = Random

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

  //  println(s"""sorted: ${sortedData.mkString(", ")}""")
  println("<==main")
}
