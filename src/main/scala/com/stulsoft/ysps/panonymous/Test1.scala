package com.stulsoft.ysps.panonymous

/**
  * Playing with anonymous objects.
  *
  * Created by Yuriy Stul on 10/7/2016.
  */
object Test1 extends App {
  println("==>start")
  f1()
  println("==>finish")

  /**
    * Using anonymous object with new {...}
    */
  def f1(): Unit = {
    println("==>f1")
    val v1 = new {
      val a = 1
      val b = 2
    }
    println(s"v1.a=${v1.a}, v1.b=${v1.b}")
    // Error v1.a couldn't be reassigned
    //    v1.a = 7

    val v2 = new {
      var a = 1
      var b = 2
    }
    println(s"v2.a=${v2.a}, v2.b=${v2.b}")

    v2.a = 7
    println(s"v2.a=${v2.a}, v2.b=${v2.b}")

    println("<==f1")
  }
}
