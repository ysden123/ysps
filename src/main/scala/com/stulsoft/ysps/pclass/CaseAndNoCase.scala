package com.stulsoft.ysps.pclass

/**
  * @author Yuriy Stul.
  */
object CaseAndNoCase extends App {

  def test1(): Unit = {
    println("==>test1")
    val c1 = CaseClass("test")
    val c2 = new NoCaseClass("test")
    val r1 = c1 match {
      case CaseClass(x) => x
      case _ => "none"
    }
    val r2 = c2 match {
      case x: NoCaseClass => x.name
      case _ => "none"
    }
    println(s"r1:$r1, r2=$r2")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")

    def f(x: AnyRef): String = {
      x match {
        case CaseClass(v) => v
        case v: NoCaseClass => v.name
        // object NoCaseClass is not a case class, nor does it have an unapply/unapplySeq member
        //        case NoCaseClass(v)=> "error"
        case _ => "none"
      }
    }

    val r1 = f(CaseClass("test"))
    val r2 = f(new NoCaseClass("test"))
    println(s"r1:$r1, r2=$r2")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")

    def f(x: AnyRef): String = {
      x match {
        case CaseClass(v) => v
        case v: NoCaseClass => v.name
        case NoCaseClass2(v) => v
        case _ => "none"
      }
    }

    val r1 = f(CaseClass("test1"))
    val r2 = f(new NoCaseClass("test1"))
    val r3 = f(new NoCaseClass2("test3"))
    println(s"r1:$r1, r2=$r2, r3=$r3")
    println("<==test3")
  }

  // Case class
  case class CaseClass(name: String)

  // Without unapply
  class NoCaseClass(val name: String)

  // With unapply
  class NoCaseClass2(val name: String)

  object NoCaseClass2 {
    def unapply(arg: NoCaseClass2): Option[String] = Some(arg.name)
  }

  test1()
  test2()
  test3()
}
