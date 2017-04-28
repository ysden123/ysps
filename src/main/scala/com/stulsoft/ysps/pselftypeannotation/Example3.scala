/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pselftypeannotation

/**
  * Declares common Converter interface
  *
  * @tparam T a type
  */
trait Converter[T] {
  /**
    * Adds two values
    *
    * @param v1 1st value
    * @param v2 2nd value
    * @return result of adding
    */
  def add(v1: T, v2: T): T
}

/**
  * 1st implementation of String Converter
  */
trait StringConverter extends Converter[String] {
  /**
    * Adds two strings
    *
    * @param v1 1st value
    * @param v2 2nd value
    * @return result of adding
    */
  override def add(v1: String, v2: String): String = v1 + v2
}

/**
  * 2nd implementation of String Converter
  */
trait StringConverter2 extends Converter[String] {
  /**
    * Adds two strings
    *
    * @param v1 1st value
    * @param v2 2nd value
    * @return result of adding
    */
  override def add(v1: String, v2: String): String = s"$v1 | $v2"
}

/**
  * 1st implementation of Int Converter
  */
trait IntConverter extends Converter[Int] {
  /**
    * Adds two Int
    *
    * @param v1 1st value
    * @param v2 2nd value
    * @return result of adding
    */
  override def add(v1: Int, v2: Int): Int = v1 + v2
}

/**
  * 2nd implementation of Int Converter
  */
trait IntConverter2 extends Converter[Int] {
  /**
    * Adds two Int and multiplies sum on 10
    *
    * @param v1 1st value
    * @param v2 2nd value
    * @return result of adding
    */
  override def add(v1: Int, v2: Int): Int = 10 * (v1 + v2)
}

/**
  * Some work class that uses Converter interface
  *
  * @tparam T a type
  */
class Worker[T] {
  // Self annotation
  this: Converter[T] =>
  /**
    * Some function that uses Converter.add function
    *
    * @param v1 1st value
    * @param v2 2nd value
    * @return result of adding
    */
  def adding(v1: T, v2: T): T = add(v1, v2)
}

/**
  * @author Yuriy Stul
  */
object Example3 extends App {
  println("==>main")
  val wString = new Worker[String] with StringConverter
  val rString = wString.add("str1", "str2")
  println(s"rString: $rString")
  val wString2 = new Worker[String] with StringConverter2
  val rString2 = wString2.add("str1", "str2")
  println(s"rString2: $rString2")

  val wInt = new Worker[Int] with IntConverter
  val rInt = wInt.add(1, 2)
  println(s"rInt: $rInt")
  val wInt2 = new Worker[Int] with IntConverter2
  val rInt2 = wInt2.add(1, 2)
  println(s"rInt2: $rInt2")
  println("<==main")
}
