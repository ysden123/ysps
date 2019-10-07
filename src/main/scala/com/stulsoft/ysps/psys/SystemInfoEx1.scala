package com.stulsoft.ysps.psys

/**
  * @author Yuriy Stul
  */
object SystemInfoEx1 extends App {
  osName()

  def osName(): Unit = {
    println(s"""OS name: ${System.getProperty("os.name")}""")
  }
}
