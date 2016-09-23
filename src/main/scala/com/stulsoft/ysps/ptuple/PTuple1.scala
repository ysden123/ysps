package com.stulsoft.ysps.ptuple

/**
  * Playing with tuple
  *
  * Created by Yuriy Stul on 9/20/2016.
  */
object PTuple1 {
  def main(args: Array[String]): Unit = {
    println("==>main")
    t01()
    t02()
    println("<==main")
  }

  def t01(): Unit = {
    println("==>t01")
    val t1 = (1, "abc")
    println(s"t1 = $t1")
    println(s"t1._1 = ${t1._1}, t1._2 = ${t1._2}")
    lazy val t2 = ("a" -> 123, "b" -> 789)
    println(s"t2._1 = ${t2._1}, t2._2 = ${t2._2}")
    println(s"t2._1._1 = ${t2._1._1}, t2._1._2 = ${t2._1._2}, t2._2._1 = ${t2._2._1}, t2._2._2 = ${t2._2._2}")
    val t3 = (1, 2, 3, 4)
    println(s"t3._1 = ${t3._1}, t3._2 = ${t3._2}, t3._3 = ${t3._3}, t3._4 = ${t3._4}")
    println("<==t01")
  }

  def t02(): Unit = {
    println("==>t02")
    val hostPort = ("localhost", 3000)
    hostPort match {
      case ("localhost", port) => println(s"It is local host. Port is $port")
      case (host, port) => println(s"It is non-local $host. Port is $port")
    }

    ("a.b.c", 80) match {
      case ("localhost", port) => println(s"It is local host. Port is $port")
      case (host, port) => println(s"It is non-local $host host. Port is $port")
    }

    println("<==t02")
  }
}
