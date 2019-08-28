/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.ptraits.init

/**
  * @author Yuriy Stul
  */
trait Foo {
  def x: String // <----------------- def, not val!
  require(x != null, "x was null")
}

class Bar extends {
  val x = "Initialized x from Bar"
} with Foo

class Bar2 extends Foo{
  override def x: String = "Initialized x from Bar2"
}

// Throws exception!
class Bar3 extends Foo{
  override def x: String = null
}

object Runner123 extends App {
  val b = new Bar
  println(s"b.x = ${b.x}")
  val b2 = new Bar2
  println(s"b2.x = ${b2.x}")
  val b3 = new Bar3
  println(s"b3.x = ${b3.x}")
}