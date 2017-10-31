package com.stulsoft.ysps.pstack

/** Usage of List as stack
  *
  * @author Yuriy Stul.
  */
object StackEx01 extends App {
  test1()
  test2()
  test3()
  test4()

  def test1(): Unit = {
    println("==>test1")
    var stack = List(1, 2, 3)

    var v = stack.head
    stack = stack.tail
    println(s"v=$v")

    v = stack.head
    stack = stack.tail
    println(s"v=$v")

    v = stack.head
    stack = stack.tail
    println(s"v=$v")

    println(stack.length)
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    var stack = List(1, "Two", new RuntimeException("test"))
    var v = stack.head
    stack = stack.tail
    println(s"v=$v")

    v = stack.head
    stack = stack.tail
    println(s"v=$v")

    v = stack.head
    stack = stack.tail
    println(s"v=$v")

    println(stack.length)

    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    var stack = List(1, "Two", new RuntimeException("test"))

    def nextItem(): Any = {
      val item = stack.head
      stack = stack.tail
      item
    }

    (1 to 3).foreach(_ => {
      val item = nextItem()
      item match {
        case x: Int => println(s"Int value $x")
        case x: String => println(s"String value $x")
        case x: Throwable => println(s"Throwable value ${x.getMessage}")
        case _ => println("Unmatched")
      }
    }
    )
    println("<==test3")
  }

  def test4(): Unit = {
    println("==>test4")
    var stack = List(1, "Two", new RuntimeException("test"))

    def nextItem(): Option[Any] = {
      if (stack.nonEmpty) {
        val item = stack.head
        stack = stack.tail
        Some(item)
      } else {
        None
      }
    }

    def handleItem(): Unit = {
      nextItem() match {
        case None =>
        case Some(item) => item match {
          case x: Int => println(s"Int value $x")
          case x: String => println(s"String value $x")
          case x: Throwable => println(s"Throwable value ${x.getMessage}")
          case _ => println("Unmatched")
        }
          handleItem()
      }
    }

    handleItem()
    println("<==test4")
  }
}
