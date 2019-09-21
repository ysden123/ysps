/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pproduct

/**
  * @author Yuriy Stul
  */
object ProductEx1 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val o1 = new MyProductEx1("n1", 123)
    println(s"o1.name = ${o1.name()}")
    println(s"o1.age = ${o1.age()}")
    println(s"o1.toString: ${o1.toString}")

    println(s"o1.productPrefix: ${o1.productPrefix}")

    o1.productIterator.foreach(println)

    println(s"o1.productElement(0) = ${o1.productElement(0)}")
    println(s"o1.productElement(1) = ${o1.productElement(1)}")
    println(s"""o1.canEqual(("nnnn",456)) = ${o1.canEqual(("nnnn", 456))}""")
    val o2 = new MyProductEx1("n2", 456)
    println(s"""o1.canEqual(o2) = ${o1.canEqual(o2)}""")
    println(s"o1 == o2: ${o1 == o2}")
    println(s"""o1 == new MyProductEx1("n1", 123): ${o1 == new MyProductEx1("n1", 123)}""")
    println(s"""o1.equals(new MyProductEx1("n1", 123)): ${o1.equals(new MyProductEx1("n1", 123))}""")

  }
}

final class MyProductEx1(name: String, age: Int) extends Product with Serializable {
  require(name != null, "name is null")

  override def productArity: Int = 2

  override def productElement(n: Int): Any = {
    n match {
      case 0 =>
        name
      case 1 =>
        age
      case i =>
        throw new NoSuchElementException(s"No such element for $i")
    }
  }

  override def canEqual(that: Any): Boolean = that.isInstanceOf[MyProductEx1]

  override def equals(obj: Any): Boolean = {
    canEqual(obj) && name == obj.asInstanceOf[MyProductEx1].name() && age == obj.asInstanceOf[MyProductEx1].age()
  }

  def nameWithAge(): String = name ++ age.toString

  def name(): String = name

  def age(): Int = age
}
