/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes

/**
  * @author Yuriy Stul
  */
object GetTypeInRuntime extends App {
  test1(new SomeClass1)
  test1(new SomeClass2)
  test1(new String)
  test1(Long.box(1))
  test1(Int)
  test1(Long)
  test1("Long text")

  def test1(o: AnyRef): Unit = {
    println("==>test1")
    println(s"o.getClass = ${o.getClass}")
    println("<==test1")
  }
}

class SomeClass1

class SomeClass2
