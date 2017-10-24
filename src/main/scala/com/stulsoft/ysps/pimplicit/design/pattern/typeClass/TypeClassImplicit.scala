/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pimplicit.design.pattern.typeClass

import java.io.File

/** Examples of Type Class Implicit usage
  *
  * @author Yuriy Stul
  */
class TypeClassImplicit {
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
    convertToJson("Hey")  // Str("Hey")
    convertToJson(123)  // Num(123)
    convertToJson(new File("test.txt"))  // Error: scala.MatchError: . (of class java.io.File)
  }

  def withImplicits(): Unit = {

  }
}
