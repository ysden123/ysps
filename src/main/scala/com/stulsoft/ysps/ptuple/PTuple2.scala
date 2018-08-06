package com.stulsoft.ysps.ptuple

/** Playing with tuples and list of tuples
  *
  * @author Yuriy Stul
  * @since 4/16/2018
  */
object PTuple2 extends App {
  test1()
  test2()
  test3()

  def test1(): Unit = {
    println("==>test1")
    val t1 = "a" -> "1"
    val t2 = "b" -> "2"
    println(s"t1: $t1, t2: $t2")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val l1 = List("t1" -> "t1 text", "t2" -> "t2 text")
    println(s"l1: $l1")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    val l1 = List("t1" -> Set("t11 text", "t12 text"), "t2" -> Set("t21 text", "t22 text"))
    println(s"l1: $l1")
    println("<==test3")
  }
}
