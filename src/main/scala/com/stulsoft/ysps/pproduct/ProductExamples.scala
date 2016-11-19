/*
 * Copyright (c) 2016. Yuriy Stul
 */

package com.stulsoft.ysps.pproduct

/**
  * Playing with Product.
  *
  * @see [[http://daily-scala.blogspot.co.il/2009/12/product.html]]
  *
  *      Created by Yuriy Stul on 11/19/2016.
  */
object ProductExamples extends App {
  println("==>Start")
  val p1: Product = (1, '2', 3)
  p1.productIterator.foreach(println)

  //>> p1.productArity = 3
  println(s"p1.productArity = ${p1.productArity}")

  //>> p1.productElement(2) = 3
  println(s"p1.productElement(2) = ${p1.productElement(2)}")

  //>> p1.productPrefix: Tuple3
  println(s"p1.productPrefix: ${p1.productPrefix}")

  //>> p13._2 = 2
  val p13 = p1.asInstanceOf[Product3[Int, Char, Int]]
  println(s"p13._2 = ${p13._2}")

  case class Test(name:String, passed:Boolean, error:String)
  var t1 = Test("Chicken Little", false, "the sky is falling")

  //>> t1.productArity = 3
  println(s"t1.productArity = ${t1.productArity}")

  //>> t1.productIterator.mkString(","): Chicken Little,false,the sky is falling
  println(s"""t1.productIterator.mkString(","): ${t1.productIterator.mkString(",")}""")

  println("==>End")
}
