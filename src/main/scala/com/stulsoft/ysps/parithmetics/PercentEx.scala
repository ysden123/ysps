/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.parithmetics

/**
  * @author Yuriy Stul
  */
object PercentEx extends App {

  def test1(): Unit ={
    println("==>test1")
    def calcUsage(capacity:Long,restriction:Long):Double={
      100.0d * capacity.toDouble / restriction.toDouble
    }
    var capacity:Long= 30
    var restriction:Long=30
    var usage:Double=calcUsage(capacity,restriction)
    println(s"capacity=$capacity, restriction=$restriction, usage=$usage, usage >= 100.0d is ${usage >= 100.0d}")

    capacity=29
    usage=calcUsage(capacity,restriction)
    println(s"capacity=$capacity, restriction=$restriction, usage=$usage, usage >= 100.0d is ${usage >= 100.0d}")

    capacity=30
    restriction=31
    usage=calcUsage(capacity,restriction)
    println(s"capacity=$capacity, restriction=$restriction, usage=$usage, usage >= 100.0d is ${usage >= 100.0d}")

    capacity=30
    restriction=29
    usage=calcUsage(capacity,restriction)
    println(s"capacity=$capacity, restriction=$restriction, usage=$usage, usage >= 100.0d is ${usage >= 100.0d}")

    println("<==test1")
  }

  test1()
}
