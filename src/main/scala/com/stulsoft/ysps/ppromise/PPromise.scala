/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.ppromise

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}
import scala.util.Random

/**
  * Created by Yuriy Stul on 10/8/2016.
  *
  * See original http://srirangan.net/2013-01-controlling-flow-with-scala-futures
  */
object PPromise extends App {
  println("==>main")
  // Promise can be used to compose type safe future
  val willYouMarryMe = Promise[Boolean]
  willYouMarryMe.future onSuccess {
    //    case yes => println("Yes! :D")
    case _ => println("Yes! :D")
  }
  willYouMarryMe.future onFailure {
    //    case no => println("No! :(")
    case _ => println("No! :(")
  }

  Future {
    Thread.sleep(1000)
    if (new Random().nextBoolean())
      willYouMarryMe success true
    else
      willYouMarryMe failure new Exception
  }

  println("Will you marry me?")
  Thread.sleep(2000)
  println("<==main")
}
