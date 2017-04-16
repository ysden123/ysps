/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.pfunction

/**
  * Demonstrates usage void function.
  *
  * Created by Yuriy Stul on 11/24/2016.
  */
object VoidFunc extends App {
  println("==>main")

  /**
    * A function with function as argument
    *
    * Allows usage a function without arguments and returns nothing (Unit)
    *
    * @param f a function without arguments; doesn't return a result (Unit)
    */
  def foo(f: () => Unit): Unit = {
    println("==>foo")
    f()
    println("<==foo")
  }

  /**
    * A function with function as argument
    *
    * Allows usage a function without arguments and returns any type and Unit too.
    *
    * @param f a function without arguments; returns any type (T) and nothing (Unit) too
    * @tparam T specifies return type for f function
    */
  def foo2[T](f: () => T): Unit = {
    println("==>foo2")
    f()
    println("<==foo2")
  }

  foo(() => println("In the f for foo"))
  foo2(() => println("In the f for foo2"))
  println("<==main")
}
