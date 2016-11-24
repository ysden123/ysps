/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.function

/**
  * Demonstrates usage void function.
  *
  * Created by Yuriy Stul on 11/24/2016.
  */
object VoidFunc extends App {
  println("==>main")

  /**
    * A function with function as argument
    * @param f a function without arguments; doesn't return a result (Unit)
    */
  def foo(f: () => Unit): Unit = {
    println("==>foo")
    f()
    println("<==foo")
  }

  foo(() => println("In the f"))
  println("<==main")
}
