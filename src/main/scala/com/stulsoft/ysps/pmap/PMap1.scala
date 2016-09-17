package com.stulsoft.ysps.pmap

import scala.runtime.Nothing$

/**
  * Playing with map and flatMap
  * Created by Yuriy Stul on 9/17/2016.
  */
object PMap1 {
  def main(args: Array[String]): Unit = {
    println("==>main")
    map1()
    map2()
    flatMap1()
    println("<==main")
  }

  def map1(): Unit = {
    println("==>map1")
    val l = List(1, 2, 3, 4, 5)
    l.map(x => x * 2)
    println(s"l: $l")
    println(s"l.map(x => x * 2): ${l.map(x => x * 2)}")
    println("<==map1")
  }

  def map2(): Unit = {
    println("==>map2")
    val l = List(1, 2, 3, 4, 5)
    def f(x: Int) = if (x > 2) Some(x) else None
    l.map(x => f(x))
    println(s"l: $l")
    println(s"l.map(x => f(x)): ${l.map(x => f(x))}")
    println("<==map2")
  }

  def flatMap1(): Unit = {
    println("==>flatMap1")
    val l = List(1, 2, 3, 4, 5)
    def f(v: Int) = List(v - 1, v, v + 1)
    println(s"l.map(x => f(x)): ${l.map(x => f(x))}")
    println(s"l.flatMap(x => f(x)): ${l.flatMap(x => f(x))}")
    println("<==flatMap1")
  }
}
