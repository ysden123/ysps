/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pclass

/** Playing with instantiation of abstract class
  *
  * @author Yuriy Stul
  */
object PlayingWithAbstractClass extends App {
  test()

  def test(): Unit = {
    println("==>test")
    abstract class TheAbstractClass {
      def age: Int
    }
    val tac1 = new TheAbstractClass {
      override def age: Int = 111
    }
    println(s"tac1.age = ${tac1.age}")

    case class TheClass(theAge: Int) {
      def toAbstractClass: TheAbstractClass = {
        new TheAbstractClass {
          override def age: Int = theAge
        }
      }
    }
    val tac2 = TheClass(456).toAbstractClass
    println(s"tac2.age = ${tac2.age}")

    println("<==test")
  }

}
