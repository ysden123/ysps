package com.stulsoft.ysps.parray

import scala.collection.mutable.ArrayBuffer

/** Multi-dimensional array
  *
  * @author Yuriy Stul.
  */
object PMultiDimensionalArray extends App {
  test1()
  test2()
  test3()

  def test1(): Unit = {
    println("==>test1")
    val a = Array(Array(Array.ofDim[String](5)))
    a(0)(0)(0) = "l1"
    println(s"a:$a")
    a.foreach(a1 => a1.foreach(a2 => a2.foreach(println)))
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    println("<==test2")
    val a = Array(Array(Array.ofDim[String](5)))
    a(0)(0)(0) = "l1"
    println(s"a.length = ${a.length}")
    println(s"a(0).length = ${a(0).length}")
    println(s"a(0)(0).length = ${a(0)(0).length}")
  }

  def test3(): Unit = {
    println("==>test3")
    val a0 = ArrayBuffer[ArrayBuffer[ArrayBuffer[String]]]()
    val a1 = ArrayBuffer[ArrayBuffer[String]]()
    val a2 = ArrayBuffer[String]()
    a2 += "l1"
    a2 += "l2"
    a2 += "l3"
    a1 += a2
    a0 += a1

    println(s"a0.size = ${a0.size}")
    println(s"a0(0).size = ${a0(0).size}")
    println(s"a0(0)(0).size = ${a0(0)(0).size}")


    println("<==test3")
  }
}
