/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.pcollection

/**
  * Playing with Vector.
  *
  * Created by Yuriy Stul on 11/17/2016.
  */
object PVector extends App {
  println("==>Start")

  val v1 = Vector("aaa", "bbb", "ccc")

  // Concatenate
  val r1 = v1.reduceLeft((v1, v2) => v1 + "\t" + v2)
  println(s"r1: $r1")

  println(s"""r2: ${v1.mkString("\t")}""")
  println("==>End")
}
