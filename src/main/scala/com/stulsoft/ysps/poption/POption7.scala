package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul
  * @since 3/22/2018
  */
object POption7 extends App {
  def test1(): Option[String] = {
    Option("test1")
  }
  def test2(): Option[String] = {
    Some("test2")
  }
  println(s"test1()=${test1()}, test2()=${test2()}")
}
