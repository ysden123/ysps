package com.stulsoft.ysps.pgenerics

import scala.reflect.ClassTag

/**
  * Playing with number operations.
  *
  * @author Yuriy Stul.
  */
object NumOps extends App {
  def f(x: Double): Double = {
    x + 0.1
  }

  def f(x: Int): Int = {
    x + 1
  }

  case class Test1[T: ClassTag](x: T) {
    def f(y: Double): Double = {
      x.asInstanceOf[Double] + y
    }

    def f(y: Int): Int = {
      x.asInstanceOf[Int] + y
    }
  }

  case class Test2[T: ClassTag](x: Array[T]) {
    def f(y: Array[Double]): Array[Double] = {
      y.indices.foreach(i =>
        x(i) = (x(i).asInstanceOf[Double] + y(i)).asInstanceOf[T]
      )
      x.asInstanceOf[Array[Double]]
    }

    def f(y: Array[Int]): Array[Int] = {
      y.indices.foreach(i =>
        x(i) = (x(i).asInstanceOf[Int] + y(i)).asInstanceOf[T]
      )
      x.asInstanceOf[Array[Int]]
    }
  }

  println(s"f(1.0) = ${f(1.0)}")
  println(s"f(1) = ${f(1)}")

  println(s"Test1(1.0).f(0.2) = ${Test1(1.0).f(0.2)}")
  println(s"Test1(10).f(20) = ${Test1(10).f(20)}")

  println(s"""Test2(Array(1.0, 2.0)).f(Array(10.0, 20.0)) = ${Test2(Array(1.0, 2.0)).f(Array(10.0, 20.0)).mkString(", ")}""")
  println(s"""Test2(Array(1, 2)).f(Array(101, 202)) = ${Test2(Array(1, 2)).f(Array(101, 202)).mkString(", ")}""")
  // error:
//  println(s"""Test2(Array(11.0, 22.0)).f(Array(101, 202)) = ${Test2(Array(11.0, 22.0)).f(Array(101, 202)).mkString(", ")}""")
}
