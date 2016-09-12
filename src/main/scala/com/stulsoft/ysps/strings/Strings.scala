package com.stulsoft.ysps.strings

/**
  * Created by Yuriy Stul on 9/12/2016.
  */
object Strings {

  def main(args: Array[String]): Unit = {
    println("==>main")
    formatting()
    compare()
    outPutter()
    println("<==main")
  }

  def formatting(): Unit = {
    println("==>formatting")
    val s1 = "the string 1"
    val i1 = 1
    val f1 = 1.123
    println(s"s1:$s1, i1=$i1, f1=$f1")
    println(f"s1:$s1%s, i1=$i1%d, f1=$f1%2.2f")
    println(raw"Result: \n a \n b \t c")
    val raw = "\n a \n b \t c"
    println(raw"Result: $raw")
    println("<==formatting")
  }

  def compare(): Unit = {
    println("==>compare")
    val s1 = "test 1"
    val s2 = "test 1"
    println(s1 == s2)
    println(s1.compare(s2))
    println("<==compare")
  }

  def outPutter(): Unit = {
    println("==>outPutter")
    val s = "tTgGhH"
    s.toLowerCase match {
      case "ttgghh" => println("very good!")
      case _ => println("very bad!")
    }

    println(s.toLowerCase match {
      case "ttgghh" => "very good!"
      case _ => "very bad!"
    })

    println(if (s.toLowerCase == "ttgghh") "very good!" else "very bad!" )
    
    println("<==outPutter")
  }
}
