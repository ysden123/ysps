/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pgenerics

import scala.reflect.runtime.universe._

/**
  * Playing with WeakTypeTag
  *
  * @see [[https://medium.com/byte-code/overcoming-type-erasure-in-scala-8f2422070d20#.pq8ocqkbt Overcoming type erasure in Scala]]
  * @author Yuriy Stul
  */
object WeakTypeTagEx01 extends App {

  abstract class SomeClass[T] {

    val list: List[T]

    object Recognizer {
      def recognize[T](x: T)(implicit tag: WeakTypeTag[T]): String =
        tag.tpe match {
          case TypeRef(utype, usymbol, args) =>
            List(utype, usymbol, args).mkString("\n")
        }
    }

    println(Recognizer.recognize(list))
  }

  println("==>main")
  new SomeClass[Int] {
    val list = List(1)
  }

  println("<==main")
}
