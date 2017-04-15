/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.function

/**
  * @see [[http://www.slatekit.com/scala101.html#scala-functions-hof-return HOF: Call by name]]
  * @author Yuriy Stul
  */
object CallByName2 extends App {
  def showCallByName(): Unit = {
    println("==>showCallByName")
    // this block of code is wrapped up as a function and called.
    // With call by name, you DO NOT have to use syntax () => for passing a function
    refactor1 {
      println("refactor this code!")
    }


    // Without call by name, notice you MUST use syntax () => for passing a function
    refactor2(() => {
      println("refactor this code!")
    })
    println("<==showCallByName")
  }

  // CALL BY NAME: takes a code block using syntax : =>
  def refactor1(block: => Unit): Unit = {
    println("==>refactor1")
    println("some code before call block")
    block
    println("<==refactor1")
  }

  // Same function using normal function
  def refactor2(block: () => Unit): Unit = {
    println("==>refactor2")
    println("some code before call block")
    block()
    println("<==refactor2")
  }

  showCallByName()
}
