/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes

/**
  * @author Yuriy Stul
  */
object LongNull extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val cond = false
    val sle = new SomeLongEntity(0)
    val result1 = sle.id == null
    println(result1)
    println("<==test1")
  }
}

//class SomeLongEntity(@BeanProperty val id:Long)
class SomeLongEntity(val id: Long)
