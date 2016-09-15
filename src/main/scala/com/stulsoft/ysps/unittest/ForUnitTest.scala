package com.stulsoft.ysps.unittest

/**
  * @author Yuriy Stul.
  *         Created on 9/15/2016.
  */
class ForUnitTest {
  def test(): Unit = {
    println("==>test")
    println("<==test")
  }

  def increase(i: Int): Int = {
    println("==>increase")
    
    i + 1
  }
}
