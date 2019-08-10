package com.stulsoft.ysps.pmatch

/** Demonstrates usage of type patterns; adding variable to pattern; <i>@</i>
  *
  * <p>
  * See <a href="https://alvinalexander.com/scala/how-to-use-pattern-matching-scala-match-case-expressions">Type patterns</a>
  * by Alvin Alexander
  *
  * @author Yuriy Stul
  */
object PTypeMatch extends App {
  test1()
  test2()
  test3()

  def matchType(x: Any): String = x match {
    //    case x: List (1, _*) => s"$x " // doesn't compile
    case x @ List(1, _*) => s"$x" // works; prints the list
    //    case Some(_) => "got a Some" // works, but can't access the Some
    //    case Some(x) => s"$x" // works, returns string value
    case x @ Some(_) => s"$x" // works, returns "Some(a value)"
    case p @ Person(_, "Doe") => s"$p"  // works, returns "Person(John,Doe)"
    case x =>
      println(s"Unknown type $x")
      ""
  }

  def test1(): Unit = {
    println("==>test1")
    println(matchType(List(1, 2, 3, 4, 5)))
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    println(matchType(Some("some value")))
    println("<==test2")
  }

  def test3(): Unit ={
    println("==>test3")
    println(matchType(Person("John", "Doe")))
    println(matchType(Person("John", "NoDoe")))
    println("<==test3")
  }
}

case class Person(firstName: String, lastName: String)