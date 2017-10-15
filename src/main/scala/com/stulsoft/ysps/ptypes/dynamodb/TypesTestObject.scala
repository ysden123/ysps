/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes.dynamodb

/**
  * Using ''Trait'' with ''new'' operator
  * @author Yuriy Stul
  */
object TypesTestObject extends App {
  trait DynamoDataType[T] {
    def convert(value: Any): T
  }

  val IntDynamoType = new DynamoDataType[Int]{
    def convert(value: Any): Int = value match {
      case Some(x: Int)    => x
      case Some(x: Long)   => x.toInt
      case Some(x: Double) => x.toInt
      case Some(x: Float)  => x.toInt
      case Some(x: Any)    => x.toString.toInt
      case None            => 0
      case x: Int          => x
      case x: Long         => x.toInt
      case x: Double       => x.toInt
      case x: Float        => x.toInt
      case x               => x.toString.toInt
    }
  }
  test1()
  def test1(): Unit ={
    println("==>test1")
    val i1 = IntDynamoType
    println(IntDynamoType)
    println(i1)
    println(i1.convert(2.0))
    println("<==test1")
  }
}
