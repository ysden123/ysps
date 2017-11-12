package com.stulsoft.ysps.pequal

/** Playing with equals
  *
  * @author Yuriy Stul.
  */
object EqualEx1 extends App {
  test1()
  test2()
  test3()
  test4()
  test5()

  def test1(): Unit = {
    println("==>test1")
    val i: Int = 123
    val l: Long = 123L
    println(s"i == l -->${i == l}")
    // the result type of an implicit conversion must be more specific than AnyRef
    //    println(s"i.eq(l) -->${i.eq(l)}")
    println(s"i.equals(l) -->${i.equals(l)}")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val s1 = "Test"
    val s2 = "Test"
    println(s"s1 == s2 --> ${s1 == s2}")
    println(s"s1 == null --> ${s1 == null}")
    println(s"s1 eq s2 --> ${s1 eq s2}")
    println(s"s1 equals s2 --> ${s1 equals s2}")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    case class A1(name: String, age: Int)
    val a1 = A1("test", 12)
    val a2 = A1("test", 12)
    println(s"a1 == a2 --> ${a1 == a2}")
    println(s"a1 eq a2 --> ${a1 eq a2}")
    println(s"a1 equals a2 --> ${a1 equals a2}")
    println("<==test3")
  }

  def test4(): Unit = {
    println("==>test4")
    class A1(val name: String, val age: Int)
    class A2(override val name: String, override val age: Int) extends A1(name, age)
    val a1 = new A1("test", 12)
    val a11 = new A1("test", 12)
    val a2 = new A2("test", 12)
    println(s"a1 == a2 --> ${a1 == a2}")
    println(s"a1 eq a2 --> ${a1 eq a2}")
    println(s"a1 equals a2 --> ${a1 equals a2}")
    println(s"a1 == a11 --> ${a1 == a11}")
    println(s"a1 eq a11 --> ${a1 eq a11}")
    println(s"a1 equals a11 --> ${a1 equals a11}")
    println("<==test4")
  }

  def test5(): Unit = {
    println("==>test5")
    class A1(val name: String, val age: Int) {
      override def equals(obj: scala.Any): Boolean = obj match {
        case x: A1 => name == x.name && age == x.age
        case _ => false
      }
    }
    class A2(override val name: String, override val age: Int) extends A1(name, age)
    val a1 = new A1("test", 12)
    val a11 = new A1("test", 12)
    val a2 = new A2("test", 12)
    println(s"a1 == a2 --> ${a1 == a2}")
    println(s"a1 == null --> ${a1 == null}")
    println(s"a1 eq a2 --> ${a1 eq a2}")
    println(s"a1 eq null --> ${a1 eq null}")
    println(s"a1 equals a2 --> ${a1 equals a2}")
    println(s"a1 equals null --> ${a1 equals null}")
    println(s"a1 == a11 --> ${a1 == a11}")
    println(s"a1 == null --> ${a1 == null}")
    println(s"a1 eq a11 --> ${a1 eq a11}")
    println(s"a1 eq null --> ${a1 eq null}")
    println(s"a1 equals a11 --> ${a1 equals a11}")
    println(s"a1 equals null --> ${a1 equals null}")
    println("<==test5")
  }
}
