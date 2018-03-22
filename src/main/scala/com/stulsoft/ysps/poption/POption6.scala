package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul
  * @since 3/22/2018
  */
object POption6 extends App {
  val x1: Option[Long] = Some(123L)
  println(s"(1) x1=$x1")
  if (x1.isDefined)
    println(s"(2) x1=${x1.get}")
  x1 match {
    case Some(x) => println(s"(3) x1=${x}")
    case _ =>
  }

  // ERROR - val x2:Option[Long] = 123L
}
