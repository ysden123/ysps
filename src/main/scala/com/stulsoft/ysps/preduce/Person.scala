package com.stulsoft.ysps.preduce

/**
  * Created by Yuriy Stul on 9/24/2016.
  */
class Person(val age: Int, val height: Int, val name: String) {
  override def toString: String = s"name: $name, age = $age, height = $height"
}

object Person {
  def apply(age: Int, height: Int, name: String): Person = {
    new Person(age, height, name)
  }
}
