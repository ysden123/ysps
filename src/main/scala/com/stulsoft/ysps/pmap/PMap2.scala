package com.stulsoft.ysps.pmap

/**
  * Created by Yuriy Stul on 9/19/2016.
  */
object PMap2 {

  abstract class TClass[T] {
    def map[U](f: (T) => U): U
  }

  class TClassStr[String](s: String) extends TClass[String] {
    override def map[U](f: (String) => U): U = f(s)
  }

  def main(args: Array[String]): Unit = {
    println("==>main")
    val s1 = new TClassStr("abc")
    println(s"s1.map(_.length)=${s1.map(_.length)}")
    println(s"s1.map(_.isEmpty)=${s1.map(_.isEmpty)}")
    println(s"s1.map(_.toUpperCase)=${s1.map(_.toUpperCase)}")
    println("<==main")
  }
}
