/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pimplicit.design.pattern.typeClass

/** Examples of Type Class Implicit usage
  *
  * @author Yuriy Stul
  */
class TypeClassImplicit {

  /**
    * Without implicits - runtime error
    */
  def withoutImplicits(): Unit = {
    sealed trait Json
    case class Str(s: String) extends Json
    case class Num(v: Double) extends Json
    // ... many more definitions

    def convertToJson(x: Any): Json = {
      x match {
        case s: String => Str(s)
        case v: Double => Num(v)
        case i: Int => Num(i)
      }
    }

    convertToJson("Hey") // Str("Hey")
    convertToJson(123) // Num(123)
    //    convertToJson(new File("test.txt")) // Runtime Error: scala.MatchError: . (of class java.io.File)
  }

  /**
    * With implicits - compile time error
    */
  def withImplicits(): Unit = {
    sealed trait Json
    case class Str(s: String) extends Json
    case class Num(v: Double) extends Json
    // ... many more definitions

    trait Jsonable[T] {
      def serialize(t: T): Json
    }
    object Jsonable {

      implicit object JsonableString extends Jsonable[String] {
        override def serialize(s: String): Json = Str(s)
      }

      implicit object JsonableDouble extends Jsonable[Double] {
        override def serialize(d: Double): Json = Num(d)
      }

      implicit object JsonableInt extends Jsonable[Int] {
        override def serialize(i: Int): Json = Num(i)
      }

    }

    def convertToJson[T](x: T)(implicit converter: Jsonable[T]): Json = {
      converter.serialize(x)
    }

    convertToJson("Hey") // Str("Hey")
    convertToJson(123) // Num(123)
    //    convertToJson(new File("test.txt")) // Compilation error: could not find implicit value for parameter converter: Jsonable[java.io.File]
  }
}
