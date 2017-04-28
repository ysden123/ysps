/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pfunction

/**
  * Demonstrates usage of call by name with block or normal function
  *
  * @author Yuriy Stul
  */
object CallByNameBlockOrFunc extends App {
  println("==>main")
  var result: String = callBlock({
    "It is a block"
  })
  println(result)
  result = callBlock {
    "It is a block"
  }
  println(result)
  result = callBlock(aConstant)
  println(result)
  result = callBlock {
    aConstant
  }
  println(result)

  // Warning! It is only theoretic example
  result = callFunction(funcNoParam)
  println(result)

  result = callFunctionWithParam(funcWithParam, "it is funcWithParam")
  println(result)
  println("<==main")

  def callBlock(block: => String): String = {
    block
  }

  def callFunction(func: () => String): String = {
    func()
  }

  def callFunctionWithParam(func: (String) => String, p: String): String = {
    func(p)
  }

  def funcNoParam(): String = {
    "This is a function without parameters"
  }

  def funcWithParam(p: String): String = {
    p.toUpperCase()
  }

  def aConstant: String = {
    "It is some String constant"
  }
}
