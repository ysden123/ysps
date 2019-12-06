/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pforcomprehansion

case class CustomType(text: String) {
  /** Could be used in for-comprehensions
    *
    * @param f function for converting CustomType to another CustomType
    * @return a CustomType
    */
  def map(f: CustomType => CustomType): CustomType = {
    println("In map")
    CustomType("some text")
  }

  def flatMap(f: CustomType => Array[Int]): Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
}

case class CustomType2(text: String) {
  /** Could NOT be used in for-comprehensions
    *
    * @param f function for converting CustomType2 to String
    * @return string
    */
  def map(f: CustomType2 => String): String = {
    println("In map 2")
    "some text"
  }

  //  def flatMap(f: CustomType => Array[Int]): Array[Int] = Array(1, 2, 3, 4, 5, 6, 7, 8, 9)
}

object CustomTypeRunner extends App {
  test1()
  test1_1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    val ct = CustomType("test text")
    val items = for {
      i <- ct
    } yield i
    println(s"items: $items")
    println("<==test1")
  }

  def test1_1(): Unit = {
    println("==>test1_1")
    val ct = CustomType("test text")
    val items = for (
      i <- ct
    ) yield i
    println(s"items: $items")
    println("<==test1_1")
  }

  def test2(): Unit = {
    println("==>test2")
    val ct = CustomType2("test text")
    val r = ct.map(x => x.text)
    println(s"r: $r")

    /* Error in compilation
        for {
          i <- ct
        } yield i
    */

    val items = for {
      i <- ct.text
    } yield i
    println(s"items: $items")

    println("<==test2")
  }

}
