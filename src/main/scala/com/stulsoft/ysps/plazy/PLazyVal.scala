package com.stulsoft.ysps.plazy

object PLazyVal {
  lazy val lv: Int = {
    println("Initialize the lazy value")
    123
  }

  val nv:Int = {
    println("Initialize non lazy value")
    456
  }

  def main(args: Array[String]): Unit = {
    println("==>main")
    println(s"lv=$lv")
    println(s"nv=$nv")
  }
}
