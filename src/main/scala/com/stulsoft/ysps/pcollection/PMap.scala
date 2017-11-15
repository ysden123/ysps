package com.stulsoft.ysps.pcollection

/**
  * @author Yuriy Stul.
  */
object PMap extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    val m: Map[String, TestTrait] = Map("k1" -> IntTest(1), "k2" -> StrTest("2"))

    m.get("k1") match {
      case Some(x: TestTrait) =>
        println(s"x: $x")
      case None =>
        println("None")
    }

    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val m: Map[String, TestTrait] = Map("k1" -> IntTest(1), "k2" -> StrTest("2"))
    val w = Work(m)
    w.makeWork("k1")
    println("<==test2")
  }

  trait TestTrait

  case class IntTest(v: Int) extends TestTrait

  case class StrTest(v: String) extends TestTrait

  case class Work[T >: TestTrait](values: Map[String, T]) {
    def makeWork(key: String): Unit = {
      values.get(key) match {
        case Some(x: TestTrait) =>
          println(s"x: $x")
        case Some(_) =>
        case None =>
          println("None")
      }
    }
  }

}
