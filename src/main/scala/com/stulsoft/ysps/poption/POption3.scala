package com.stulsoft.ysps.poption

/** Playing with collection of Option
  * @author Yuriy Stul.
  */
object POption3 extends App {
test1()
  def test1(): Unit ={
    println("==>test1")
//    val list = List[Option[String]](Option("string1"), Option("string2"), Option.empty, Option("string3"))
    val list = List(Option("string1"), Option("string2"), Option.empty, Option("string3"))
    println(s"list: $list")

    val listWithMap = list.map({
      case Some(s)=> s
      case _ => None
    })
    println(s"listWithMap: $listWithMap")

    val listWithValuesOnly = list.filter(_.isDefined).map(x => x.get)
    println(s"listWithValuesOnly: $listWithValuesOnly")

//    val listWithMap2 = list.map(x=>x.get)
//    println(s"listWithMap2: $listWithMap2")

    list.flatMap(x => x.map(x=>x)).foreach(println)
    println("")
    list.flatten.foreach(println)

//    println("")
//    list.foreach(println)
    println("<==test1")
  }
}
