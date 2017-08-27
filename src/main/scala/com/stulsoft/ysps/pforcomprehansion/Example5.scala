/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pforcomprehansion

/**
  * @author Yuriy Stul
  */
object Example5 extends App {
  for (i <- 1 to 3;
       j <- 1 to 5
  ) {
    println(s"$i,$j")
  }

  println()

  for (i <- 3 to 1 by -1;
       j <- 5 to 1 by -1
  ) {
    println(s"$i,$j")
  }

}
