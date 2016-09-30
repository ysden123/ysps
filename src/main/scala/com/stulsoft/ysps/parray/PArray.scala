package com.stulsoft.ysps.parray

/**
  * Created by Yuriy Stul on 9/30/2016.
  */
object PArray {
  def main(args: Array[String]): Unit = {
    println("==>main")
    extractor()
    println("<==main")
  }

  def extractor(): Unit = {
    println("==>extractor")
    
    def extract(a:Array[Any]): Unit ={
      val Array(c1,c2,c3,c4) = a
      println(s"c1=$c1, c2=$c2, c3=$c3, c4=$c4")
      println(s"c1 class is ${c1.getClass.getName}")
    }

    var a = Array(1,2,"three", "four")
    extract(a)

    a = Array("one","two","three", "four")
    extract(a)
    println("<==extractor")
  }
}
