/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.pclone

/**
  * Created by Yuriy Stul on 11/25/2016.
  */
object Clone1 extends App {
  /**
    * Using clone
    */
  def test1(): Unit = {
    println("==>test1")
    val v1 = Array(1, "a", 3.0)

    // Wrong!
    val v2 = v1
    v2(0) = v2(0).asInstanceOf[Int] + 2
    println(s"""v1: ${v1.mkString(",")}, v2: ${v2.mkString(",")}""")

    // Correct!
    val v3 = v1.clone()
    v3(0) = v3(0).asInstanceOf[Int] + 2
    println(s"""v1: ${v1.mkString(",")}, v3: ${v3.mkString(",")}""")

    println("<==test1")
  }

  /**
    * Using map
    */
  def test2(): Unit = {
    println("==>test2")
    val v1 = Array(1, "a", 3.0)
    val v2 = v1.map(v => v)
    v2(0) = v2(0).asInstanceOf[Int] + 2
    println(s"""v1: ${v1.mkString(",")}, v2: ${v2.mkString(",")}""")
    println("<==test2")
  }

  /**
    * Using flatMap
    */
  def test3(): Unit = {
    println("==>test3")
    val v1 = Array(1, "a", 3.0)
    // If an element is 1 then add element 10, else the element
    val v2 = v1.flatMap(x => if (x == 1) x :: 10 :: Nil else x :: Nil)
    println(s"""v1: ${v1.mkString(",")}, v2: ${v2.mkString(",")}""")
    println("<==test3")
  }

  println("==>main")
  test1()
  test2()
  test3()
  println("<==main")
}
