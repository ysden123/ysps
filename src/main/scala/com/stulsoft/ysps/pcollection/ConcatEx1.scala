package com.stulsoft.ysps.pcollection

/**
  * @author Yuriy Stul
  * @since 4/9/2018
  */
object ConcatEx1 extends App {
  var l = List(1, 2, 3)
  println(s"l=$l")
  l ++= List(4, 5, 6)
  println(s"l=$l")

/* ERROR: l1 is not assignable
  val l1 = List(1, 2, 3)
  println(s"l1=$l1")
  l1 ++= List(4, 5, 6)
  println(s"l1=$l1")
*/

}
