package com.stulsoft.ysps.pduration

import scala.concurrent.duration._

/**
  * @author Yuriy Stul.
  *         Created on 9/15/2016.
  */
object PDuration {
  def main(args: Array[String]): Unit = {
    println("==>main")
    var fiveSec = 5 seconds;
    println(s"fiveSec=$fiveSec")
    fiveSec = 15.seconds
    println(s"fiveSec=$fiveSec")
    println("<==main")
  }
}
