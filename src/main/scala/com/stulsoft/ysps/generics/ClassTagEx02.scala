package com.stulsoft.ysps.generics

import scala.reflect.{ClassTag, classTag}

/**
  * Playing with ClassTag.
  *
  * @see [[https://scalerablog.wordpress.com/2015/12/21/classtag-class-and-war-stories/ ClassTag, Class and war stories…]]
  * @author Yuriy Stul.
  */
object ClassTagEx02 extends App {
  def f1[T: ClassTag](x: T): Unit = {
    println(s"classTag[T].getClass: ${classTag[T].getClass}")
    println(s"classTag[T].runtimeClass: ${classTag[T].runtimeClass}")
    println(s"classTag[T].runtimeClass.isAssignableFrom(classTag[String].runtimeClass): ${classTag[T].runtimeClass.isAssignableFrom(classTag[String].runtimeClass)}")

    val a1: Array[T] = Array.ofDim(5)
    println(s"a1: $a1")

    val theType = x match {
      case _: java.lang.String => "String"
      case _: java.lang.Double => "Double"
      case _: java.lang.Float => "Float"
      case _ => "Unsupported"
    }
    println(s"theType is $theType")
  }

  println("==>main")
  f1("text")
  f1(1.0)
  f1[Float](1.0F)
  f1(1)
  println("<==main")
}
