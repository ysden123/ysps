package com.stulsoft.ysps.peither

/**
  * Created by Yuriy Stul on 9/15/2016.
  */
case class AppError(msg: String)

object MainAppError {
  def main(args: Array[String]): Unit = {
    test1()
    test2()
    test3()
  }

  /**
    * Returns Either object.
    *
    * If shouldFail is true, then result is Left[AppError]
    * If shouldFail is false, then result is Right[String]
    *
    * @param shouldFail specifies either to fail or not.
    * @return Either with Left[AppErr], if shouldFail is true; otherwise - Right[String]
    */
  def getMeMyStringPeasant(shouldFail: Boolean): Either[AppError, String] =
  shouldFail match {
    case true => Left(AppError("We failed you!"))
    case false => Right("We always win!")
  }

  def test1(): Unit = {
    println("==>test1")
    val result = getMeMyStringPeasant(false)

    // Since we asked for the “Good” result, we do some transformation
    // and print out the result.
    result.map("(1) " + _ + " But why do I need right?")
      .foreach(println(_))
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val result = getMeMyStringPeasant(true)

    // Does nothing!
    result.map("(1) " + _ + " But why do I need right?")
      .foreach(println(_))

    // Print the error out to the user
    result.left.foreach(error => println("(2) " + error.msg))

    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    println("Fail")
    var result = getMeMyStringPeasant(true)
    println(s"getMeMyStringPeasant(true) is $result.")
    result = getMeMyStringPeasant(false)
    println(s"getMeMyStringPeasant(false) is $result.")

    result = getMeMyStringPeasant(true)
    result match{
      case Left(AppError(msg)) => println(s"Failure. Error: ${msg}")
      case Right(success) =>  println(s"Success. Message: $success")
    }

    getMeMyStringPeasant(false) match{
      case Left(AppError(msg)) => println(s"Failure. Error: ${msg}")
      case Right(success) =>  println(s"Success. Message: $success")
    }

    println("<==test3")
  }
}