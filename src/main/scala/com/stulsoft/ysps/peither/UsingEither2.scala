package com.stulsoft.ysps.peither

/**
  * Created by Yuriy Stul on 9/16/2016.
  */
object UsingEither2 {
  def getData(shouldFail: Boolean): Either[String, List[String]] = {
    shouldFail match {
      case true => Left("Error was occurred")
      case false =>
        val list = List[String]("String 1", "Text 2", "Line 3")
        Right(list)
    }
  }

  def getLeftOnly(): Unit = {
    println("==>getLeftOnly")
    var result = getData(false)
    println("Should not fail. Result (empty):")
    result.left.foreach(println)

    result = getData(true)
    println("\nShould fail. Result (not empty):")
    result.left.foreach(println)
    println("<==getLeftOnly")
  }

  def getRightOnly(): Unit = {
    println("==>getRightOnly")
    var result = getData(false)
    println("Should not fail. Result (not empty):")
    result.right.foreach {
      _.foreach(println)
    }

    result = getData(true)
    println("\nShould fail. Result (empty):")
    result.right.foreach {
      _.foreach(println)
    }
    println("<==getRightOnly")
  }

  def general(): Unit = {
    println("==>general")

    println("With error")
    getData(true) match {
      case Left(err) => println(s"We got error $err")
      case Right(l) =>
        println("Result:")
        l.foreach(println)
    }

    println("\nWithout error")
    getData(false) match {
      case Left(err) => println(s"We got error $err")
      case Right(l) =>
        println("Result:")
        l.foreach(println)
    }
    println("<==general")
  }

  def main(args: Array[String]): Unit = {
    println("==>main")
    getLeftOnly()
    getRightOnly()
    general()
    println("<==main")
  }
}
