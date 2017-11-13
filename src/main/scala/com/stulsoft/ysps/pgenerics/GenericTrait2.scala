/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pgenerics

/** Playing with trait and generics
  *
  * @author Yuriy Stul
  */
object GenericTrait2 extends App {

  val ti1 = TestInt(1)
  val tis1 = Map("first" -> TestInt(2), "second" -> TestInt(3))
  println(s"makeCompareWith(ti1,tis1)=${makeCompareWith(ti1, tis1)}")

  def makeCompareWith[T](left: TestTrait[T], rights: Map[String, TestTrait[T]]): Boolean = {
    val right = rights.get("first")
    val r = right match {
      case Some(x: TestTrait[T]) =>
        left.compareWith(x)
      case None =>
        false
    }
    r
  }

  trait TestTrait[T] {
    def compareWith(that: TestTrait[T]): Boolean
  }

  case class TestInt(v: Int) extends TestTrait[Int] {
    override def compareWith(that: TestTrait[Int]): Boolean = that match {
      case TestInt(x) => v < x
    }
  }

  case class TestString(v: String) extends TestTrait[String] {
    override def compareWith(that: TestTrait[String]): Boolean = that match {
      case TestString(x) => v < x
    }
  }

}
