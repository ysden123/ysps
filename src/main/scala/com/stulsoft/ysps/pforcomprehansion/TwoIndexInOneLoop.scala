/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pforcomprehansion

/** Implementation of Java for(int i=1,j=3; i <= 3 && j <= 2; ++i,++j)
  *
  * @author Yuriy Stul
  */
object TwoIndexInOneLoop extends App {
  for ((i, j) <- Seq((1, 2), (2, 3)))
    println(s"i=$i, j=$j")

  val yieldResult = for {
    i <- Seq(1, 2, 3)
    j <- Seq(5, 6)
  } yield (i, j)
  println(s"yieldResult: $yieldResult")

  val yieldResult2 = for {
    i <- 5 to 1 by -1
    j <- 2 to 1 by -1
  } yield (i, j)
  println(s"yieldResult2: $yieldResult2")
}
