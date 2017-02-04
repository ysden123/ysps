/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.types

/**
  * Playing with types
  *
  * @see [[https://twitter.github.io/scala_school/type-basics.html Type & polymorphism basics]]
  * @author Yuriy Stul
  */
object TypeEx01 extends App {

  /*
    * Covariant:      [+T]  C[T’] is a subclass of C[T]
    * Contravariant:  [-T]  C[T] is a subclass of C[T']
    * Invariant:      [T]   C[T] and C[T’] are not related
    */
  class Covariant[+T]

  class Contravariant[-T]

  class Invariant[T]

  println("==>main")
  val cv: Covariant[AnyRef] = new Covariant[String]
  //  val cvError:Covariant[String] = new Covariant[AnyRef]

  val ctv: Contravariant[String] = new Contravariant[AnyRef]
  //  val ctvError: Contravariant[AnyRef] = new Contravariant[String]

  val inv: Invariant[String] = new Invariant[String]
  //  val invError: Invariant[String] = new Invariant[AnyRef]
  //  val invError: Invariant[AnyRef] = new Invariant[String]

  println("<==main")
}
