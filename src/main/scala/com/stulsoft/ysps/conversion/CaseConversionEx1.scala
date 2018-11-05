/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.conversion

/**
  * @author Yuriy Stul
  */
object CaseConversionEx1 extends App {
  println("==>CaseConversionEx1")
  println(ForConvEx1(List("yuriy", "11", "70.0")))
  println("<==CaseConversionEx1")
}

case class ForConvEx1(name: String, age: Int, weight: Double)

object ForConvEx1 {
  def apply(args: Seq[String]): ForConvEx1 = new ForConvEx1(args.head,
    args(1).toInt, args(2).toDouble)
}