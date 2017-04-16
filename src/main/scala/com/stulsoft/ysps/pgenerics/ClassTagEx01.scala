/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pgenerics

import scala.reflect.ClassTag

/**
  * Playing ClassTag
  *
  * @see [[https://medium.com/byte-code/overcoming-type-erasure-in-scala-8f2422070d20#.pq8ocqkbt Overcoming type erasure in Scala]]
  * @author Yuriy Stul
  */
object ClassTagEx01 extends App {

  val list = List(1, "string1", List(), "string2")
  val result1 = Extractor1.extract[String](list)

  println("==>main")
  val result2 = Extractor2.extract[String](list)

  println("Extractor1")

  /**
    * Wrong, warning in compilation.
    */
  object Extractor1 {
    def extract[T](list: List[Any]): List[T] = list.flatMap {
      case element: T => Some(element)
      case _ => None
    }
  }

  println(result1) // List(1, string1, List(), string2)

  println("Extractor2")

  /**
    * Correct
    */
  object Extractor2 {
    def extract[T](list: List[Any])(implicit tag: ClassTag[T]): List[T] =
      list.flatMap {
        case element: T => Some(element)
        case _ => None
      }
  }

  println(result2) // List(string1, string2)
  println("<==main")
}
