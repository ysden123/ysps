/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes

/**
  * Playing with types
  *
  * @see [[https://twitter.github.io/scala_school/type-basics.html Type & polymorphism basics]]
  * @author Yuriy Stul
  */
object ContravariantEx01 extends App {

  val getTweet: (Bird => String) = (a: Animal) => a.sound

  println("==>main")
  val b = new Bird
  println(getTweet(b))

  val c = new Chicken
  println(getTweet(c))
  println("<==main")
}
