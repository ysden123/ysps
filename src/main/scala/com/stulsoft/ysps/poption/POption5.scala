package com.stulsoft.ysps.poption

/** Converting {{{List[Option[T]]}}} to {{{List[T]}}}
  *
  * @author Yuriy Stul.
  */
object POption5 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val l: List[Option[String]] = List(Some("text1"), None, Some("text2"))
    println(s"l: $l")
    val r1 = for {
      i <- l
    } yield i
    println(s"r1: $r1")

    val r2 = for {
      i <- l
      if i.isDefined
      s <- i.get
    } yield s
    println(s"r2: $r2")

    val r3 = for {
      i <- l.filter(_.isDefined).map(_.get)
    } yield i
    println(s"r3: $r3")

    val r4 = l.filter(_.isDefined).map(_.get)
    println(s"r4: $r4")

    println("<==test1")
  }
}
