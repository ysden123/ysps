/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes.dynamodb

/**
  * @author Yuriy Stul
  */
object TableTraitTest extends App {

  def test(): Unit = {
    val c1 = new C1("the test")
    c1.showType()
  }

  trait T2 {
    type T = this.type
    def showType(): Unit ={
      println("T")
    }
  }

  test()

  class C1(val name: String) extends T2

}
