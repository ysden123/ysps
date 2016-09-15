package com.stulsoft.ysps.pmatch

/**
  * Created by Yuriy Stul on 9/15/2016.
  */
object PMatch {
  def main(args: Array[String]): Unit = {
    var s = "123"
    var r = s match{
      case "12" | "123" => "The 123"
      case _ => "Other"
    }
    println(s"s=$s, r=$r")

    s = "789"
    r = s match{
      case "12" | "123" => "The 123"
      case _ => "Other"
    }
    println(s"s=$s, r=$r")
  }
}
