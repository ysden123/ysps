/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.ysps.pforcomprehansion

/**
 * @author Yuriy Stul
 */
object Example8 extends App {
  val list = List("abc", "ggjhgjh", "tyyttttuytu")

  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    val items: Seq[(String, Int)] = list.map(text => (text, text.length))
    println(items)
  }

  def test2(): Unit = {
    println("==>test2")
    val items: Seq[(String, Int)] = for {
      item <- list
    } yield (item, item.length)
    println(items)
  }
}
