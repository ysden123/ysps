/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.ysps.pargs

/**
  * Playing with _* as argument
  */
object ArgsEx1 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    new C1("111", "222")
    new C1("111", "222", "333")
    // ERROR: 4444 is invalid argument new C1("111", "222", "333", 4444)
    println("<==test1")
  }

  class C1(val args: String*) {
    println(s"args.length=${args.length}")
    args.foreach(println)
  }

}
