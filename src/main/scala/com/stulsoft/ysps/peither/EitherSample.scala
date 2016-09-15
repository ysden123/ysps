package com.stulsoft.ysps.peither

import scala.io.StdIn

/**
  * Playing with Either.
  *
  * Convention dictates that Left is used for failure and Right is used for success.
  *
  * Created by Yuriy Stul on 9/14/2016.
  */
object EitherSample {
  def main(args: Array[String]): Unit = {
    println("==>main")
    test1()
    test2()
    test3()
    println("<==main")
  }

  def test1(): Unit = {
    println("==>test1")
    val in = StdIn.readLine("Type Either a string or an Int: ")
    val result: Either[String, Int] = try {
      Right(in.toInt)
    } catch {
      case e: Exception =>
        Left(in)
    }

    println(result match {
      case Right(x) => "You passed me the Int: " + x + ", which I will increment. " + x + " + 1 = " + (x + 1)
      case Left(x) => "You passed me the String: " + x
    })

    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val l: Either[String, Int] = Left("flower")
    val r: Either[String, Int] = Right(12)

    println(s"l.left = ${l.left}")
    println(s"l.right = ${l.right}")
    println(s"r.left = ${r.left}")
    println(s"r.right = ${r.right}")

    println("====================")
    println(s"l.left.map(_.size): Either[Int, Int]=${l.left.map(_.length): Either[Int, Int]}")
    println(s"l.right.map(_.toDouble): Either[String, Double]=${l.right.map(_.toDouble): Either[String, Double]}")
    println(s"r.left.map(_.size): Either[Int, Int]=${r.left.map(_.length): Either[Int, Int]}")
    println(s"r.right.map(_.toDouble): Either[String, Double]=${r.right.map(_.toDouble): Either[String, Double]}")
    println("<==test2")
  }

  def validate(t: String): Either[String, String] = {
    if (t.nonEmpty) Right(t) else Left("***ERROR")
  }

  def test3(): Unit ={
    println("==>test3")
    println(s"""validate("") is ${validate("")}""")
    println(s"""validate("abc") is ${validate("abc")}""")
    println("<==test3")
  }
}
