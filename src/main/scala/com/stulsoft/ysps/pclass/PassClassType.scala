package com.stulsoft.ysps.pclass

/**
  * @author Yuriy Stul.
  */
object PassClassType extends App {
class C1(val name:String)
  test()
  test1()
  def test(): Unit ={
    val t = classOf[C1]
    println(t.getDeclaredFields.map(f =>
      f.getName
    ).toList)
  }

  def test1(): Unit ={
    fields(classOf[C1])
  }

  def fields[T](clazz:Class[T]): Unit ={
    println(clazz.getDeclaredFields.map(f =>
      f.getName
    ).toList)
  }
}
