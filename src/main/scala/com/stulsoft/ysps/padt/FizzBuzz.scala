/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.padt

/**
  * @author Yuriy Stul
  */
object FizzBuzz extends App {


  def test1(): Unit = {
    println("==>test1")
    LazyList(1 to 10: _*).map(FizzBuzzADT(_)).foreach(println)
    println("<==test1")
  }

  def test2() {
    println("==>test2")
    val even: Int => Boolean = i => i % 2 == 0

    // Pretend the Stream[Int] came from somewhere else
    LazyList(1 to 10: _*).map(FizzBuzzADT(_)).foreach {
      case a@Fizz(i) if even(i) => println(a)
      case a@Buzz(i) if even(i) => println(a)
      case a@FizzBuzz(i) if even(i) => println(a)
      case a@JustInt(i) if even(i) => println(a)
      case _ => // Be quiet
    }

    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    LazyList(1 to 10: _*).map(FizzBuzzADT(_)).foreach {
      case Fizz(_) => // Down with the bloody bad Fizz
      case x => println(x)
    }
    println("<==test3")
  }

  sealed abstract class FizzBuzzADT(i: Int) {
    override def toString: String = i.toString
  }

  case class Fizz(i: Int) extends FizzBuzzADT(i) {
    override val toString = "Fizz"
  }

  case class Buzz(i: Int) extends FizzBuzzADT(i) {
    override val toString = "Buzz"
  }

  case class FizzBuzz(i: Int) extends FizzBuzzADT(i) {
    override val toString = "FizzBuzz"
  }

  test1()
  test2()
  test3()

  case class JustInt(i: Int) extends FizzBuzzADT(i)

  object FizzBuzzADT {
    def apply(i: Int): FizzBuzzADT = i match {
      case _ if i % 3 == 0 && i % 5 == 0 => FizzBuzz(i)
      case _ if i % 3 == 0 => Fizz(i)
      case _ if i % 5 == 0 => Buzz(i)
      case _ => JustInt(i)
    }
  }

}
