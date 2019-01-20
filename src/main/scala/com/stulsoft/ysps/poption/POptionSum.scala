/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul
  */
object POptionSum extends App {
  def func1(items: Seq[Container]): Option[Double] = {
    val forSum = items
      .filter(_.total.isDefined)
      .map(_.total.get)

    if (forSum.nonEmpty)
      Option(forSum.sum)
    else
      Option.empty
  }

  def func2(items: Seq[Container]): Option[Double] = {
    val forSum = for (
      item <- items;
      t <- item.total
    ) yield t

    if (forSum.nonEmpty)
      Option(forSum.sum)
    else
      Option.empty
  }

  def func3(items: Seq[Container]): Option[Double] = {
    var calculated = false
    var sum: Double = 0.0
    items.foreach(item => item.total.foreach(total => {sum += total;calculated = true}))
    if (calculated)
      Option(sum)
    else
      Option.empty
  }

  def test1(): Unit = {
    println("==>test1")
    var result = func1(List(Container("1", Option(1.0)), Container("2", Option.empty)))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")

    result = func1(List(Container("1", Option(1.0)), Container("2", Option(2.0))))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")

    result = func1(List(Container("1", Option.empty), Container("2", Option.empty)))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    var result = func2(List(Container("1", Option(1.0)), Container("2", Option.empty)))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")

    result = func2(List(Container("1", Option(1.0)), Container("2", Option(2.0))))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")

    result = func2(List(Container("1", Option.empty), Container("2", Option.empty)))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    var result = func2(List(Container("1", Option(1.0)), Container("2", Option.empty)))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")

    result = func2(List(Container("1", Option(1.0)), Container("2", Option(2.0))))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")

    result = func2(List(Container("1", Option.empty), Container("2", Option.empty)))
    if (result.isDefined)
      println(s"result=${result.get}")
    else
      println("Undefined")
    println("<==test3")
  }

  println("Start")
  test1()
  test2()
  test3()
  println("End")
}

case class Container(name: String, var total: Option[Double])
