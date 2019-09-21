/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pfunction

/**
  * @author Yuriy Stul
  */
object ValAndFunctionAccess extends App {
  val i = ValAndFunctionAccessTestClass("123", "1234")
  println(s"i.valFunction1(10)= ${i.valFunction1(10)}")
  println(s"i.valFunction2(10,20)= ${i.valFunction2(10, 20)}")
  println(s"i.defFunction1(10)= ${i.defFunction1(10)}")
  println(s"i.defFunction2(10,20)= ${i.defFunction2(10, 20)}")
}

case class ValAndFunctionAccessTestClass(n1: String, n2: String) {
  val valFunction1: Int => Int = (a: Int) => {
    a + n1.length + n2.length
  }

  val valFunction2: (Int, Int) => Int = (a: Int, b: Int) => {
    a + b + n1.length + n2.length
  }

  def defFunction1(a: Int): Int = {
    a + n1.length + n2.length
  }

  def defFunction2(a: Int, b: Int): Int = {
    a + b + n1.length + n2.length
  }
}
