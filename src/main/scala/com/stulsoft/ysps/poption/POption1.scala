/*
 * Copyright (c) 2017. Yuriy Stul 
 */

package com.stulsoft.ysps.poption

/**
  * Playing with Option
  *
  * @author Yuriy Stul
  */
object POption1 extends App {

  var s: Option[String] = _

  private def fooReturnObject: Option[String] = {
    Some("test")
  }

  println("==>main")

  private def fooReturnNone: Option[String] = {
    None
  }

  private def fooReturnNoneByNull: Option[String] = {
    Option(null)
  }

  // Usage the isDefined
  private def showResult1(o: Option[String], comment: String): Unit = {
    print(s"$comment ")
    if (o.isDefined)
      println(s"o: ${o.get}")
    else
      println("o: not specified")
  }

  // Usage the default value
  private def showResult2(o: Option[String], comment: String): Unit = {
    println(s"""$comment o: ${o.getOrElse("not specified")}""")
  }

  // Usage the pattern matching
  private def showResult3(o: Option[String], comment: String): Unit = {
    print(s"$comment ")
    o match {
      case Some(x) => println(s"o: $x")
      case None => println(s"o: not specified")
    }
  }

  // Usage the foreach
  private def showResult4(o: Option[String], comment: String): Unit = {
    print(s"$comment ")
    o.foreach(s => print(s"o: $s"))
    println
  }

  private def showProductArity(o: Option[String], comment: String): Unit = {
    println(s"$comment productArity=${o.productArity}")
  }

  println
  println("showResult1")
  showResult1(fooReturnObject, "fooReturnObject")
  showResult1(fooReturnNone, "fooReturnNone")
  showResult1(fooReturnNoneByNull, "fooReturnNoneByNull")

  println
  println("showResult2")
  showResult2(fooReturnObject, "fooReturnObject")
  showResult2(fooReturnNone, "fooReturnNone")
  showResult2(fooReturnNoneByNull, "fooReturnNoneByNull")

  println
  println("showResult3")
  showResult3(fooReturnObject, "fooReturnObject")
  showResult3(fooReturnNone, "fooReturnNone")
  showResult3(fooReturnNoneByNull, "fooReturnNoneByNull")

  println
  println("showResult4")
  showResult4(fooReturnObject, "fooReturnObject")
  showResult4(fooReturnNone, "fooReturnNone")
  showResult4(fooReturnNoneByNull, "fooReturnNoneByNull")

  println
  println("showProductArity")
  showProductArity(fooReturnObject, "fooReturnObject")
  showProductArity(fooReturnNone, "fooReturnNone")
  showProductArity(fooReturnNoneByNull, "fooReturnNoneByNull")

  println("<==main")
}
