/**
  * Copyright (c) 2016, Yuriy Stul. All rights reserved
  */

package com.stulsoft.ysps.penum

/**
  * Demonstrates path-dependent types with Enumeration.
  *
  * @author Yuriy Stul
  *
  */
object Color extends Enumeration {
  val Red: Value = Value
  val Green: Value = Value
  val Blue: Value = Value

  def theValue: Value = Value
}

/**
  * @author Yuriy Stul
  *
  */
object Color2 extends Enumeration {
  val Red, Green, Blue = Value

  def theValue: Value = Value
}

/**
  * @author Yuriy Stul
  *
  */
class Color3 extends Enumeration {
  val Red, Green, Blue = Value

  def theValue: Value = Value
}

object Color4 extends Enumeration {
  type Color4 = Value
  val Red, Green, Blue = Value
}

/**
  * @author Yuriy Stul
  *
  */
object Direction extends Enumeration {
  val North, East, South, West = Value

  def theValue: Value = Value
}

/**
  * @author Yuriy Stul
  *
  */
object Main2Enums {
  def main(args: Array[String]): Unit = {
    val c1 = Color.Blue
    val c2 = Color2.Blue
    val c3 = new Color3().Blue
    val d = Direction.East

    //	println(s"Color.Value: ${Color.Value}")
    //	println(s"${c1.theValue}")
    println(s"c1=$c1")
    println(s"c2=$c2")
    println(s"c3=$c3")
    println(s"d=$d")

    println(s"Color.theValue=${Color.theValue}")
    println(s"Color2.theValue=${Color2.theValue}")
    println(s"new Color3().theValue=${new Color3().theValue}")
    println(s"Direction.theValue=${Direction.theValue}")

    println(s"c1 == c2: ${c1 == c2}")
    println(s"Color.theValue == Color2.theValue: ${Color.theValue == Color2.theValue}")
    println(s"c1 == d: ${c1 == d}")

    println(s"Color4.Blue = ${Color4.Blue}")
  }
}