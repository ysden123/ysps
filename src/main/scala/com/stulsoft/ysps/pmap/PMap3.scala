package com.stulsoft.ysps.pmap

import scala.util.{Failure, Success, Try}

/** Playing with map and flatMap
  *
  * @author Yuriy Stul.
  */
object PMap3 extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")

    def f(c: Int): Option[String] = {
      c match {
        case 1 => Some("text")
        case 2 => None
      }
    }

    println("1:")
    println(f(1).map((s) => s))
    println(f(2).map((s) => s))

    println("\n2:")
    println(f(1).flatMap { (s) => Some(s.length) })
    println(f(2).flatMap { (s) => Some(s.length) })
    println(f(1).flatMap((s) => Some(s)))
    println(f(2).flatMap((s) => Some(s)))

    println("\n3:")
    f(1).map((s) => {println(s"s is $s");s})
    f(2).map((s) => {println(s"s is $s");s})

    println("\n4:")
    f(1).flatMap((s) => Some(s)).foreach(s => println(s"s is $s"))
    f(2).flatMap((s) => Some(s)).foreach(s => println(s"s is $s"))

    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")

    def f(c: Int): Try[String] = {
      c match {
        case 1 => Success("text")
        case 2 => Failure(new RuntimeException("test"))
      }
    }

    println("1:")
    println(f(1).map((s) => s))
    println(f(2).map((s) => s))

    println("\n2:")
    f(1).foreach((s) => println(s))
    f(2).foreach((s) => println(s))

    println("\n3:")
    println(f(1).flatMap((x) => Success(x)))
    println(f(2).flatMap((x) => Success(x)))

    println("<==test2")
  }
}