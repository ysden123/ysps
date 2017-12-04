package com.stulsoft.ysps.pstream

/**
  * @author Yuriy Stul.
  */
object StreamEx1 extends App {
  test1()
  test2()
  test3()

  def test1(): Unit = {
    println("==>test1")
    lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
    println(s"fibs.take(10)=${fibs take 10 foreach println}")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")

    def buildFibs(n: Int): Vector[BigInt] = {
      lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map(n => n._1 + n._2)
      fibs.take(n).toVector
    }

    buildFibs(10) foreach println

    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    lazy val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }
    println(fibs.tail)
    println(fibs.tail.tail)
    println(fibs.take(5))
    fibs take 5 foreach println
    println("<==test3")
  }
}
