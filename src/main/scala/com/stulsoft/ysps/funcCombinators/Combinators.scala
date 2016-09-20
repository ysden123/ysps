package com.stulsoft.ysps.funcCombinators

import scala.collection.mutable.ListBuffer

/**
  * Created by Yuriy Stul on 9/20/2016.
  */
object Combinators {
  def main(args: Array[String]): Unit = {
    println("==>main")
    zipTest()
    println("<==main")
  }

  /**
    * zip aggregates the contents of two lists into a single list of pairs.
    */
  def zipTest(): Unit = {
    println("==>zipTest")
    val l1 = List(1, 2, 3, 4)
    val l2 = List("a", "b")
    val z1 = l1.zip(l2)
    println(s"z1 = $z1")
    println(s"""l1.zip(List("aa","bb","cc")) = ${l1.zip(List("aa", "bb", "cc"))}""")

    val l3 = List.range(1, 10)
    val l4 = List.range('a', 'l')
    val z2 = l3.zip(l4)
    println(s"l3: $l3")
    println(s"l4: $l4")
    println(s"z2: $z2")

    val l5 = 100 :: l3
    println(s"l5: $l5")

    val l6 = l3 :: 100 :: Nil
    println(s"l6: $l6")

    val l7 = 1 :: 2 :: 3 :: 4 :: Nil
    println(s"l7: $l7")

    var lb1 = ListBuffer.empty[Int]
    lb1 += 1
    lb1 += 2
    lb1 += 3
    lb1 += 4
    var lb2 = ListBuffer.empty[String]
    lb2 += "a"
    lb2 += "bb"
    lb2 += "ccc"
    lb2 += "dddd"
    lb2 += "eeeee"
    val zLb1Lb2 = lb1.zip(lb2)
    println(s"lb1: $lb1")
    println(s"lb2: $lb2")
    println(s"zLb1Lb2: $zLb1Lb2")

    println("<==zipTest")
  }
}
