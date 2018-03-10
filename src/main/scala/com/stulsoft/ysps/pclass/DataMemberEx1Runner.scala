/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pclass

/**
  * @author Yuriy Stul
  */
object DataMemberEx1Runner extends App {
val d = new DataMemberEx1(456)
  println(s"d.p1=${d.p1}, d.p2=${d.p2}, d.foo()=${d.foo()}")
}
