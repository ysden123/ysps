package com.stulsoft.ysps.ptraits

/**
  * @author Yuriy Stul
  */
class Impl2(var p1: Int, var p2: String) extends Trait1 {}

object Impl2 extends App {
  val t1: Trait1 = new Impl2(123, " the test")
  println(t1.f1())
  println(s"t1.p1=${t1.p1}")
// ERROR t1.p1=345
}
