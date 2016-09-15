package com.stulsoft.ysps.pmatch

/**
  * Created by Yuriy Stul on 9/15/2016.
  */
object PMatch {
  def main(args: Array[String]): Unit = {
    test1()
    test2()
    test3()
  }

  def test1(): Unit = {
    println("==>test1")
    var s = "123"
    var r = s match {
      case "12" | "123" => "The 123"
      case _ => "Other"
    }
    println(s"s=$s, r=$r")

    s = "789"
    r = s match {
      case "12" | "123" => "The 123"
      case _ => "Other"
    }
    println(s"s=$s, r=$r")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val t = "123";
    val r = t match {
      case "123" => 1
      case _ => 0
    }

    println(s"t=$t, r=$r")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    var t = "123"
    var r = t match {
      case s if (s == "123" || s.startsWith("1")) => 1
      case _ => 0
    }
    println(s"t=$t, r=$r")

    t = "rtyrtyrty"
    r = t match {
      case s if (s == "123" || s.startsWith("1")) => 1
      case _ => 0
    }
    println(s"t=$t, r=$r")
    println("<==test3")
  }
}
