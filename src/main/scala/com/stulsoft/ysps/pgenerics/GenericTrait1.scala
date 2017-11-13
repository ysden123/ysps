/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pgenerics

/** Playing with trait and generics
  *
  * @author Yuriy Stul
  */
object GenericTrait1 extends App {

  val ti1 = TestInt(1)
  val ti2 = TestInt(2)
  println(s"makeCompareWith(ti1,ti2)=${makeCompareWith(ti1, ti2)}")

  val ts1 = TestString("1")
  val ts2 = TestString("2")
  println(s"makeCompareWith(ts1,ts2)=${makeCompareWith(ts1, ts2)}")

  def makeCompareWith[T](left: TestTrait[T], right: TestTrait[T]): Unit = {
    left match {
      case x: TestTrait[T] => println(s"(0) true")
      case _ => println(s"(0) false")
    }
    val r = left.compareWith(right)
    println(s"r=$r")
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
