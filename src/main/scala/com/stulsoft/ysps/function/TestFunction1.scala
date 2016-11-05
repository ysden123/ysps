/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.function

/**
  * Created by Yuriy Stul on 11/5/2016.
  */
object TestFunction1 {
  /**
    * Demonstrates usage of Function interface
    *
    * @return input valued incremented by 1
    */
  def testFunc1 = new Function1[Int, Int] {
    def apply(x: Int): Int = x + 1
  }

  /**
    * Demonstrates usage of Function interface with syntactic sugar
    *
    * @return input valued incremented by 1
    */
  def testFunc12 = new ((Int) => Int) {
    def apply(x: Int): Int = x + 1
  }
}
