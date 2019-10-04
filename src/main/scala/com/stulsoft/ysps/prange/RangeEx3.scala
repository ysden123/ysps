/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.prange

/** Playing with <i>init</i> and <i>inits</i> methods
  *
  * @author Yuriy Stul
  */
object RangeEx3 extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    val r = 'A' to 'C'

    println("r.init.toList.foreach(println):")
    r.init.toList.foreach(println)

    println("r.inits.toList.foreach(println):")
    r.inits.toList.foreach(println)

    println("r.inits.toList.map(_.mkString).foreach(println):")
    r.inits.toList.map(_.mkString).foreach(println)

    println("r.inits.toList.map(_.mkString).reverse.foreach(println):")
    r.inits.toList.map(_.mkString).reverse.foreach(println)

    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val l = List('A', 'B', 'C')

    println("l.init.toList.foreach(println):")
    l.init.toList.foreach(println)

    println("l.inits.toList.foreach(println):")
    l.inits.toList.foreach(println)

    println("l.inits.toList.map(_.mkString).foreach(println):")
    l.inits.toList.map(_.mkString).foreach(println)

    println("l.inits.toList.map(_.mkString).reverse.foreach(println):")
    l.inits.toList.map(_.mkString).reverse.foreach(println)

    println("<==test2")
  }
}
