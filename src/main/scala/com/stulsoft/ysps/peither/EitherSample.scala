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
//    test1()
    test2()
//    test3()
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

//    println(l.left)
//    println(r.left)
//    println(l.right)
//    println(r.right)
//
//    println("====================")
//    println(l.left.map(_.size): Either[Int, Int])
    println(l.left.map(x => x.size))
    println(l.left.map(x => x.getClass.getName))
//    println(r.left.map(_.size): Either[Int, Int])
    println(r.left.map(x => x.size))
    println(r.left.map(x => x.getClass.getName))
//    println(l.right.map(_.toDouble): Either[String, Double])
//    println(r.right.map(_.toDouble): Either[String, Double])
    println("<==test2")
  }

  def validate(t: String): Either[String, String] = {
    return if (t.size > 0) Right(t) else Left("***ERROR")
  }

  def test3(): Unit ={
    println("==>test3")
    println(s"""validate("") is ${validate("")}""")
    println(s"""validate("abc") is ${validate("abc")}""")
    println("<==test3")
  }
}
