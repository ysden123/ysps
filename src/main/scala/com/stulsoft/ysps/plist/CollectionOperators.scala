/**
  * Copyright (c) 2016, Yuriy Stul. All rights reserved
  */

package com.stulsoft.ysps.plist

import scala.collection.mutable.ArrayBuffer

/**
  * Collection operators.
  *
  * @author Yuriy Stul
  *
  */
object CollectionOperators {
  def main(args: Array[String]): Unit = {
    println("==>main")

    :+
    +:
    plus
    minus
    ++
    --
    ::
    :::
    |
    &
    &~
    +=
    -=
    ++=
    --=
    +=:
    ++=:

    println("<==main")
  }

  /**
    * Operator +:
    *
    * Adds an element at the beginning of a collection. Returns collection of same type as collection.
    *
    * Collection type - Seq
    */
  def +: {
    println("==>+:")

    val c1 = Seq(1, 2, 3)

    println(s"100 +: c1=${100 +: c1}")

    // Error: c1 +: 100

    println("<==+:")
  }

  /**
    * Operator :+
    *
    * Adds an element at the end of a collection. Returns collection of same type as collection.
    *
    * Collection type - Seq
    */
  def :+ {
    println("==>:+")

    val c1 = Seq(1, 2, 3)

    println(s"c1 :+ 1=${c1 :+ 100}")

    // Error: 100 :+ c1

    println("<==:+")
  }

  /**
    * Operator +
    *
    * Adds an element and returns a collection of same type as collection
    */
  def plus {
    println("==>plus")

    val c1 = Set(1, 2, 3)

    println(s"c1 + 100=${c1 + 100}")
    // Error: 100 + c1
    println(s"c1 + (100,110,120)=${c1 + (100, 110, 120)}")

    val m1 = Map("a" -> 1, "b" -> 2)
    val m2 = m1 + ("c" -> 3)
    println("m1 + (\"c\" -> 3)=" + m2)

    println("<==plus")
  }

  /**
    * Operator -
    *
    * Deletes an element and returns a collection of same type as collection
    */
  def minus {
    println("==>minus")

    val c1 = Set(1, 2, 3, 4)

    println(s"c1 - 2=${c1 - 2}")
    println(s"c1 - (2,3)=${c1 - (2, 3)}")

    val m1 = Map("a" -> 1, "b" -> 2, "c" -> 3)
    val m2 = m1 - "b"
    println("m1 - \"b\"=" + m2)

    println("<==minus")
  }

  /**
    * Operator ++
    *
    * Adds collection and returns a collection of same type as collection
    */
  def ++ {
    println("==>++")

    val c1 = List(1, 2, 3)
    val c2 = List(10, 2, 30)

    println(s"c1 ++ c2=${c1 ++ c2}")

    println(s"c1 ++: c2=${c1 ++: c2}")

    println("<==++")
  }

  /**
    * Operator --
    *
    * Deletes collection and returns a collection of same type as collection
    */
  def -- {
    println("==>--")

    val c1 = Set(1, 2, 3, 4, 5)
    val c2 = Set(2, 3)
    println(s"c1 -- c2=${c1 -- c2}")

    val a1 = ArrayBuffer(1, 2, 3, 4, 5, 6)
    val a2 = ArrayBuffer(2, 3)
    println(s"a1 -- a2=${a1 --= a2}")

    println(s"c1 -- a2=${c1 -- a2}")

    println(s"a1 -- c2=${a1 --= c2}")

    println("<==--")
  }

  /**
    * Operator ::
    */
  def :: {
    println("==>::")
    val c1 = List(1, 2, 3)
    val c2 = List(100, 200, 300)

    println(s"c1 :: c2 = ${c1 :: c2}")
    println(s"c2 :: c1 = ${c2 :: c1}")
    println(s"123 :: c1 = ${123 :: c1}")

    // Error
    // println(s"c1 :: 123 = ${c1 :: 123}")

    println(s"123 :: c1 :: c2 = ${123 :: c1 :: c2}")
    println(s"c1 :: 123 :: c2 = ${c1 :: 123 :: c2}")

    println("<==::")
  }

  /**
    * Operator :::
    */
  def ::: {
    println("==>:::")
    val c1 = List(1, 2, 3)
    val c2 = List(100, 200, 300)

    println(s"c1 ::: c2 = ${c1 ::: c2}")
    println(s"c2 ::: c1 = ${c2 ::: c1}")
    // Error: 123 ::: c1

    // Error: c1 :: 123

    println("<==:::")
  }

  /**
    * Operator |
    */
  def | {
    println("==>|")
    val c1 = Set(1, 2, 3)
    val c2 = Set(10, 20, 30)

    println(s"c1 | c2=${c1 | c2}")
    println(s"c2 | c1=${c2 | c1}")
    println("<==|")
  }

  /**
    * Operator &
    */
  def & {
    println("==>&")
    val c1 = Set(1, 2, 3)
    val c2 = Set(10, 20, 30)
    val c3 = Set(2)

    println(s"c1 & c2=${c1 & c2}")
    println(s"c2 & c1=${c2 & c1}")
    println(s"c1 & c3=${c1 & c3}")
    println(s"c3 & c1=${c3 & c1}")
    println("<==&")
  }

  /**
    * Operator &~
    */
  def &~ {
    println("==>&~")
    val c1 = Set(1, 2, 3)
    val c2 = Set(10, 20, 30)
    val c3 = Set(2)

    println(s"c1 &~ c2=${c1 &~ c2}")
    println(s"c2 &~ c1=${c2 &~ c1}")
    println(s"c1 &~ c3=${c1 &~ c3}")
    println(s"c3 &~ c1=${c3 &~ c1}")
    println("<==&~")
  }

  /**
    * Operator +=
    */
  def += {
    println("==>+=")
    val c1 = ArrayBuffer(1, 2, 3)

    println(s"c1 += (10,20,30)=${c1 += (10, 20, 30)}")
    println(s"c1=$c1")
    println(s"c1 += 777=${c1 += 777}")

    println("<==+=")
  }

  /**
    * Operator ++=
    */
  def ++= {
    println("==>++=")
    val c1 = ArrayBuffer(1, 2, 3)
    val c2 = ArrayBuffer(100, 200, 300)

    println(s"c1 ++= c2=${c1 ++= c2}")
    println(s"c1=$c1")

    println("<==++=")
  }

  /**
    * Operator -=
    */
  def -= {
    println("==>-=")
    val c1 = ArrayBuffer(1, 2, 3)

    println(s"c1 -= (10,2,3)=${c1 -= (10, 2, 3)}")
    println(s"c1=$c1")

    val c2 = ArrayBuffer(1, 2, 3)

    println(s"c2 -= 10=${c1 -= 10}")
    println(s"c2=$c2")

    println("<==-=")
  }

  /**
    * Operator --=
    */
  def --= {
    println("==>--=")
    val c1 = ArrayBuffer(1, 2, 3, 4, 5, 6)
    val c2 = ArrayBuffer(3, 5)

    println(s"c1 --= c2=${c1 --= c2}")
    println(s"c1=$c1")

    println("<==--=")
  }

  /**
    * Operator +=:
    */
  def +=: {
    println("==>+=:")
    val c1 = ArrayBuffer(1, 2, 3, 4, 5, 6)

    println(s"17 +=: c1=${17 +=: c1}")
    println(s"c1=$c1")

    println("<==+=:")
  }

  /**
    * Operator ++=:
    */
  def ++=: {
    println("==>++=:")
    val c1 = ArrayBuffer(1, 2, 3, 4, 5, 6)
    val c2 = ArrayBuffer(17, 19)

    println(s"c2 ++=: c1=${c2 ++=: c1}")
    println(s"c2=$c2")
    println(s"c1=$c1")

    println("<==++=:")
  }
}