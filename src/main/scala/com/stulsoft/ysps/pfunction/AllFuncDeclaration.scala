/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.ysps.pfunction

/**
 * @author Yuriy Stul
 */
object AllFuncDeclaration extends App {

  def test1(text: String, f: String => Int): Unit = {
    println("==>test1")
    println(s"f(text) = ${f(text)}")
  }

  def test2(text: String, functions: Seq[String => Int]): Unit = {
    println("==>test2")
    println(s"sum = ${functions.map(f => f(text)).sum}")
  }

  def func1(text: String): Int = {
    println("==>func1")
    text.length
  }

  val func2: String => Int = (text: String) => {
    println("==>func2")
    text.length
  }

  test1("some text", func1)
  test1("some text 2", func2)

  test2("text 22", List(func1, func2))
}
