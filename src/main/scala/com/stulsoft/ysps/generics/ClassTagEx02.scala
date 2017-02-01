package com.stulsoft.ysps.generics

import scala.reflect.{ClassTag, classTag}

/**
  * Playing with ClassTag.
  *@see [[https://scalerablog.wordpress.com/2015/12/21/classtag-class-and-war-stories/ ClassTag, Class and war stories…]]
  * @author Yuriy Stul.
  */
object ClassTagEx02 extends App {
  def f1[T: ClassTag](x: T): Unit = {
    println(s"classTag[T].getClass: ${classTag[T].getClass}")
    println(s"classTag[T].runtimeClass: ${classTag[T].runtimeClass}")
    println(s"classTag[T].runtimeClass.isAssignableFrom(classTag[String].runtimeClass): ${classTag[T].runtimeClass.isAssignableFrom(classTag[String].runtimeClass)}")
  }

  println("==>main")
  f1("text")
  println("<==main")
}
