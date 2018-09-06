/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pclass

/** Dynamic instantiation of some class
  *
  * @author Yuriy Stul
  */
object LoadClass1 extends App {
  val someClass = Class.forName("com.stulsoft.ysps.pclass.SomeClass").newInstance().asInstanceOf[SomeClass]
  println(s"result: ${someClass.f()}")
}

class SomeClass {
  def f(): String = "f"
}
