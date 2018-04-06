package com.stulsoft.ysps.pcollection

import scala.collection.mutable.ListBuffer

/**
  * @author Yuriy Stul
  * @since 4/3/2018
  */
object SplitCollection extends App {
  def splitCollection(source: Iterable[String]): (Iterable[String], Iterable[String]) = {
    val badCollection = new ListBuffer[String]
    val goodCollection = new ListBuffer[String]
    source.foreach(i => {
      if (i.startsWith("good"))
        goodCollection += i
      else
        badCollection += i
    })
    (badCollection, goodCollection)
  }

  def test1(): Unit = {
    println("==>test1")
    val result = splitCollection(List("good1", "bad1", "good2", "bad2", "good3"))
    println(s"Bad: ${result._1}")
    println(s"Good: ${result._2}")
    println("<==test1")
  }
  
  def test2(): Unit = {
    println("==>test2")
    val (bad,good) = splitCollection(List("good1", "bad1", "good2", "bad2", "good3"))
    println(s"Bad: ${bad}")
    println(s"Good: ${good}")
    println("<==test2")
  }

  test1()
  test2()
}
