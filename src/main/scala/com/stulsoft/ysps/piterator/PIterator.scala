package com.stulsoft.ysps.piterator

/**
  * Playing with iterator
  *
  * Created by Yuriy Stul on 9/17/2016.
  */
object PIterator {
  def main(args: Array[String]): Unit = {
    println("==>main")
    testIterator1()
    testIterator2()
    println("<==main")
  }

  def testIterator1(): Unit = {
    println("==>testIterator1")
    val i1 = Iterator("aaa", "bbb", "ccc")
    val i2= Iterator("aaa", "bbb", "ccc")

    println("\nwhile:")
    while (i1.hasNext) {
      println(i1.next())
    }

    println("\nmap:")
    val im = i2.map[String](x => x + "M")
    while (im.hasNext) {
      println(im.next())
    }

    println("<==testIterator1")
  }

  def testIterator2(): Unit = {
    println("==>testIterator2")
    def i = Iterator("aaa", "bbb", "ccc")
    val i1 = i
    val i2 = i

    println("\nwhile:")
    while (i1.hasNext) {
      println(i1.next())
    }

    println("\nmap:")
    val im = i2.map[String](x => x + "M")
    while (im.hasNext) {
      println(im.next())
    }

    println("<==testIterator2")
  }
}
