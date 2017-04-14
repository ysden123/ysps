/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.forcomprehansion

/**
  * You can mix options and list types in map/flatMap (Option can be seen as a simple collection)
  *
  * We want to remove empty values and increment other values
  *
  * See [[https://gist.github.com/loicdescotte/4044169 Scala for comprehension translation helper]]
  *
  * @author Yuriy Stul
  */
object Example4 extends App {
  val optNumbers = List(Some(1), Some(2), None, Some(3))

  var r1 = for {
    optNumber <- optNumbers
    value <- optNumber // Skips None value!
  } yield value + 1

  var r2 = optNumbers.flatMap(optNumber => optNumber.map(value => value + 1))

  println(s"r1 is $r1")
  println(s"r2 is $r2")
}
