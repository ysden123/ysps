/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.types

/**
  * Playing with types. Bounds.
  *
  * @see [[https://twitter.github.io/scala_school/advanced-types.html Advanced types]]
  * @author Yuriy Stul
  */
object BoundsEx02 extends App {

  /*
  Methods can enforce more complex type bounds via implicit parameters.

  A =:= B   A must be equal to B
  A <:< B   A must be a subtype of B
  */
  class StrongContainer[A](value: A) {
    def addIt(implicit evidence: A =:= Int):Int = 123 + value
  }

  println("==>main")
  println(s"new StrongContainer(123).addIt = ${new StrongContainer(123).addIt}")
  // Error
  //  println(s"""new StrongContainer("123").addIt = ${new StrongContainer("123").addIt}""")
  println("<==main")
}
