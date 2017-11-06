package com.stulsoft.ysps.ppartialfunction

/** Playing with PartialFunction
  *
  * @see [[http://blog.bruchez.name/2011/10/scala-partial-functions-without-phd.html Scala partial functions (without a PhD)]]
  * @author Yuriy Stul.
  */
object PartialFunctionEx1 extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    /**
      * Usage of val and match pattern
      */
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

  def test2(): Unit = {
    println("==>test2")

    /**
      * Usage of def
      *
      * @return
      */
    def f1 = new PartialFunction[Int, Int] {
      override def isDefinedAt(x: Int): Boolean = x != 0

      override def apply(x: Int): Int = 100 / x
    }

    /**
      * Usage of val with match patterns and argument validation
      */
    val f2: PartialFunction[Int, Int] = {
      case x if x != 0 => 100 / x
    }

    println(s"""f1(12): ${f1(12)}""")
    println(s"""f2(12): ${f2(12)}""")
    // println(s"""${f1("1")}""") ==> Error: type mismatch
    // println(s"""${f2("1")}""") ==> Error: type mismatch
    // println(s"""f1(0): ${f1(0)}""") ==> Error: java.lang.ArithmeticException: / by zero
    // println(s"""f2(0): ${f2(0)}""") //==> Error: scala.MatchError: 0 (of class java.lang.Integer)
    if (f1.isDefinedAt(0))
      println(s"""f1(0): ${f1(0)}""")
    else
      println(s"""f1(0) is not defined at 0""")

    if (f2.isDefinedAt(0))
      println(s"""f2(0): ${f2(0)}""")
    else
      println(s"""f2(0) is not defined at 0""")
    println("<==test2")
  }
}
