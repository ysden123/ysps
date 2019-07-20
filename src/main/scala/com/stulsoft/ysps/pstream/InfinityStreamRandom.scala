package com.stulsoft.ysps.pstream

import scala.util.Random

/**
  * @author Yuriy Stul.
  */
object InfinityStreamRandom extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")
    LazyList.continually(Random.nextInt(100)).take(10).foreach(println)

    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val i = LazyList.continually(Random.nextInt(100)).iterator
    (1 to 10).foreach(_ => println(i.next()))
    println("<==test2")
  }
}
