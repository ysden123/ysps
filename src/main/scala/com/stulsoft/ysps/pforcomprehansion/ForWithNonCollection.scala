/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pforcomprehansion

/**
  * Comprehension ''for'' should work with types that have flatMap member, e.g. collections
  *
  * @author Yuriy Stul
  */
object ForWithNonCollection extends App {
  test1()
  test2()

  /* Error: value flatMap is not a member of Int
    def test1(): Unit = {
      val f = for {
        i <- 123
        j <- 100
      } yield (i,j)
      println(f)
    }
  */

  def test1(): Unit = {
    println("==>test1")

    val f = for {
      i <- 123 to 123
      j <- 100 to 100
    } yield (i, j)
    println(f)

    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")

    val f = for {
      i <- 1 to 3
    } yield (i, i * 3)
    println(f)
    println("<==test2")
  }
}
