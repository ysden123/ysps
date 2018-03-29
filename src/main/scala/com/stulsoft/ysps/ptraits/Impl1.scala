package com.stulsoft.ysps.ptraits

/**
  * @author Yuriy Stul
  */
class Impl1(val p1: Int, val p2: String) extends Trait1 {

}

object Impl1 extends App {
  val t1: Trait1 = new Impl1(123, " the test")
  println(t1.f1())
  println(s"t1.p1=${t1.p1}")

}
