package com.stulsoft.ysps.poption

/** Option: map and flatMap
  *
  * @author Yuriy Stul.
  */
object POption4 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val o1: Option[String] = Some("12345")
    val o2: Option[String] = None
    val v1 = for {
      i <- o1
    } yield i.length
    println(s"v1=$v1")

    val v2 = for {
      i <- o2
    } yield i.length
    println(s"v2=$v2")

    val v3 = o1.map(x => x.length)
    println(s"v3=$v3")

    val v4 = o2.map(x => x.length)
    println(s"v4=$v4")

    val v5 = o1.flatMap(x => Option(x.length))
    println(s"v5=$v5")

    val v6 = o2.flatMap(x => Option(x.length))
    println(s"v6=$v6")
    println("<==test1")
  }
}
