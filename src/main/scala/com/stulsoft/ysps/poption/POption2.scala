/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul
  */
object POption2 extends App {
  test1()
  test2()
  test3()
  test4()
  test5()
  test6()

  def test1(): Unit = {
    println("==>test1")
    val person = Person("test", None)
    println(s"person.address: ${person.address}")

    val address = person.address
    val city = address.map(a => a.city)
    println(s"city: $city")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val person = Option(Some(Person("test", None)))
    val address = person.flatMap(p => p.value.address)
    println(s"address: $address")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    val person = Option(Some(Person("test", Some(Address("the city")))))
    val city = person.flatMap(p => p.value.address.map(a => a.city))
    println(s"city: $city")
    println("<==test3")
  }

  def test4(): Unit = {
    println("==>test4")
    val person = Option(Some(Person("test", None)))
    val city = person.flatMap(p => p.value.address.map(a => a.city))
    println(s"city: $city")
    println("<==test4")
  }

  def test5(): Unit = {
    println("==>test5")
    val person = Option(Some(Person("test", None)))
    val city = person.map(p => p.value.address).flatMap(a => if (a.isDefined) Some(a.get.city) else None)
    println(s"city: $city")

    println("<==test5")
  }

  def test6(): Unit = {
    println("==>test6")
    val person = Option(Some(Person("test", Some(Address("the city")))))
    val city = person.map(p => p.value.address).flatMap(a => if (a.isDefined) Some(a.get.city) else None)
    println(s"city: $city")
    println("<==test6")
  }
}

case class Address(city: String)

case class Person(name: String, address: Option[Address])