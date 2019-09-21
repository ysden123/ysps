/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pmatch

/** Demonstrates usage of type patterns; adding variable to pattern; <i>@</i>
  *
  * @author Yuriy Stul
  */
object MatchWithAt extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    val o = Option("Test")

    o match {
      case Some(t) => println(s"case Some(t): t = $t") // access to value only
      case _ =>
    }

    o match {
      case p@Some(t) => println(s"case p @ Some(t): p = $p, t = $t") // access to object and value
      case _ =>
    }

    o match {
      case p@Some("Test") => println(s"case p @ Some(text): p = $p") // access to object
      case _ =>
    }
  }

  def test2(): Unit = {
    println("==>test2")
    val o = SomeClass33("ttttt", "Test")

    o match {
      case SomeClass33(_, "Test") => println("Found 1")
      case _ => println("Did not found 1")
    }

    o match {
      case s@SomeClass33(_, "Test") => println(s"Found 2, s=$s")
      case _ => println("Did not found 2")
    }

    // Compilation error
    /*
        o match {
          case s:SomeClass33(_, "Test") => println(s"Found 3, s=$s")
          case _ => println("Did not found 3")
        }
    */

    o match {
      case s: SomeClass33 if s.n2 == "Test" => println(s"Found 4, s=$s")
      case _ => println("Did not found 4")
    }
  }
}

case class SomeClass33(n1: String, n2: String)
