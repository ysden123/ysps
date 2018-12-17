/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul
  */
object POption9Map extends App {
  test1()
  test2()
  test3()

  def findNone(): Option[String] = {
    None
  }

  def findSome(): Option[String] = {
    Option("aaaa")
  }

  def test1(): Unit = {
    println("==>test1")
    findNone().map(s => s.length).map(l => println(s"l=$l"))
    println("<==test1")
  }

  def f2(texts: Iterable[String]): Iterable[Int] = {
    texts.map(text => {
      findNone()
        .map(text => text.length)
    })
      .filter(r => r.isDefined)
      .map { x => x.get }
  }

  def test2(): Unit = {
    println("==>test2")
    f2(List("1111", "2222")).foreach(i => println(s"i=$i"))
    println("<==test2")
  }
  def f3(texts: Iterable[String]): Iterable[Int] = {
    texts.map(text => {
      findSome()
        .map(text => text.length)
    })
      .filter(r => r.isDefined)
      .map { x => x.get }
  }

  def test3(): Unit = {
    println("==>test3")
    f3(List("1111", "3333")).foreach(i => println(s"i=$i"))
    println("<==test3")
  }
}
