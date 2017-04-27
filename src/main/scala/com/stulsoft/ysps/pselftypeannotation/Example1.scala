/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pselftypeannotation

/**
  * @see [[https://wordpress.com/read/feeds/64906696/posts/1436965299 Self type Annotations in Cake Pattern]]
  * @author Yuriy Stul
  */
object Example1 {

  def main(args: Array[String]): Unit = {
    println("==>main")
    //    val b1 = new B1() // Error: class B1 cannot be instantiated because it does not conform to its self-type
    val b1 = new B() with A
    b1.foo()
    println("<==main")

  }

  trait A {
    def foo(): Unit = println("foo1")
  }

  class B {
    this: A =>
    foo()
  }

}
