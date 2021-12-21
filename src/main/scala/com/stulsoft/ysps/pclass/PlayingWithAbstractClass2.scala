/*
 * Copyright (c) 2021. Webpals
 */

package com.stulsoft.ysps.pclass

/**
 * @author Yuriy Stul
 */
object PlayingWithAbstractClass2 extends App {
  abstract class AC1{
    def func1(i:Int):String
  }

  abstract class AC2(factor:Int){
    def func1(i:Int):String
  }

  class ACImpl1 extends AC1 {
    override def func1(i: Int): String = s"i = $i"
  }

  class ACImpl2(factor:Int) extends AC2(factor) {
    override def func1(i: Int): String = s"i = ${i * factor}"
  }

  val ac1 = new ACImpl1()
  println(ac1.func1(5))

  val ac2 = new ACImpl2(5);
  println(ac2.func1(5))
}
