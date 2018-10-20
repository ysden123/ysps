/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.communicate.java

/**
  * @author Yuriy Stul
  */
case class ScalaObject1(name:String, age:Int, var weight:Double)

object ScalaObject1TestRunner extends App{
  val so1=ScalaObject1("some name", 123, 456.78)
  println(s"so1:$so1")
  println(s"age:${so1.age}")
  println(s"name:${so1.name}")
  println(s"(1) weight:${so1.weight}")
  //  so1.name="changed"  ERROR: val
  so1.weight=876.54
  println(s"(1) weight:${so1.weight}")
}