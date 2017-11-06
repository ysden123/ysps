package com.stulsoft.ysps.ppartialfunction

/** Playing with PartialFunction
  *
  * @see [[http://blog.bruchez.name/2011/10/scala-partial-functions-without-phd.html Scala partial functions (without a PhD)]]
  * @author Yuriy Stul.
  */
object PartialFunctionEx1 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val incAny: PartialFunction[Any, Int] = {
      case i: Int => i + 1
    }

    println(s"incAny(42)=${incAny(42)}")
    try {
      println(s"""incAny("cat")=${incAny("cat")}""")
    }
    catch {
      case e: Throwable => println(s"""incAny("cat") --> Exception is scala.MatchError: ${e.getMessage}""")
    }
    println(s"""incAny.isDefinedAt(42)=${incAny.isDefinedAt(42)}""")
    println(s"""incAny.isDefinedAt("cat")=${incAny.isDefinedAt("cat")}""")

    println(s"""List(42,"cat") collect incAny: ${List(42, "cat") collect incAny}""")
    println("<==test1")
  }
}
