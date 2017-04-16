/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pfunction

/**
  * Call by name and call by value.
  *
  * @author Yuriy Stul
  */
object CallByNameValue2 extends App {
  def func(): Int = {
    println("==>func")
    println("computing stuff....")
    42 // return something
  }

  def callByValue(x: Int): Unit = {
    println("==>callByValue")
    println("1st x: " + x)
    println("2nd x: " + x)
    println("<==callByValue")
  }

  def callByName(x: => Int): Unit = {
    println("==>callByName")
    println("1st x: " + x)
    println("2nd x: " + x)
    println("<==callByName")
  }

  callByValue(func())
  callByName(func())
}
