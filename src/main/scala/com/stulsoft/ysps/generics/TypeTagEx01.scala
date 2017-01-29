/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.generics

import scala.reflect.runtime.universe._

/**
  * Playing with TypeTag
  *
  * @see [[https://medium.com/byte-code/overcoming-type-erasure-in-scala-8f2422070d20#.pq8ocqkbt Overcoming type erasure in Scala]]
  * @author Yuriy Stul
  */
object TypeTagEx01 extends App {

  val list: List[Int] = List(1, 2)

  println("==>main")

  println("Recognizer1")
  val result1 = Recognizer1.recognize1(list)

  object Recognizer1 {
    def recognize1[T](x: T)(implicit tag: TypeTag[T]): String =
      tag.tpe match {
        case TypeRef(utype, usymbol, args) =>
          List(utype, usymbol, args).mkString("\n")
      }
  }

  println(result1)
  println("<==main")
}
