/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pforcomprehansion

/**
  * See [[https://gist.github.com/loicdescotte/4044169 Scala for comprehension translation helper]]
  *
  * @author Yuriy Stul
  */
object Example3 extends App {
  val optA: Option[String] = Some("a value")
  val optB: Option[String] = Some("b value")

  val r1 = for {
    a <- optA
    b <- optB
  } yield (a, b)
  val r2 = optA.flatMap(a => optB.map(b => (a, b)))

  val r3 = for {
    a <- optA
    if a startsWith "a"
    b <- optB
  } yield (a, b)
  val r4 = optA.withFilter(a => a startsWith "a").flatMap(a => optB.map(b => (a, b)))

  val r5 = for {
    a <- optA
    if a startsWith "c" // Non exeisting!
    b <- optB
  } yield (a, b)

  println(s"r1 is $r1")
  println(s"r2 is $r2")
  println(s"r3 is $r3")
  println(s"r4 is $r4")
  println(s"r5 is $r5")
}
