package com.stulsoft.ysps.pfuture

import com.stulsoft.ysps.util.TimeWatch

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Random

/**
  * @see [[http://www.michaelpollmeier.com/execute-scala-futures-in-serial-one-after-the-other-non-blocking Execute Scala Futures in serial one after the other (non-blocking)]]
  * @author Yuriy Stul.
  */
object FutureSerial extends App {
  test1()
  test2()
  test3()
  test4()
  private lazy val tw = TimeWatch()

  def test1(): Unit = {
    println("==>test1")
    tw.start()
    val list = generateList()

    val futures = list map doubleFuture // return List[Future[Int]]
    futures.foreach {
      future =>
        val result = Await.result(future, Duration.Inf)
        println(s"result is $result")
    }
    println(s"Duration is ${tw.duration} ms.")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    tw.start()
    val list = generateList()

    val future = Future.traverse(list)(doubleFuture) // Return Future[List[Int]]
    val results = Await.result(future, Duration.Inf)
    results.foreach(result => println(s"result is $result"))
    println(s"Duration is ${tw.duration} ms.")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    tw.start()
    val list = generateList()

    val futures = list map doubleFuture // return List[Future[Int]]
    val future = Future.sequence(futures) // Return Future[List[Int]]
    val results = Await.result(future, Duration.Inf)
    results.foreach(result => println(s"result is $result"))
    println(s"Duration is ${tw.duration} ms.")
    println("<==test3")
  }

  def test4(): Unit = {
    println("==>test4")
    tw.start()
    val list = generateList()

    val results = Await.result(serialiseFutures(list)(doubleFuture), Duration.Inf)
    results.foreach(result => println(s"result is $result"))
    println(s"Duration is ${tw.duration} ms.")
    println("<==test4")
  }

  /**
    * @see [[http://www.michaelpollmeier.com/execute-scala-futures-in-serial-one-after-the-other-non-blocking]]
    */
  def serialiseFutures[A, B](l: Iterable[A])(fn: A => Future[B]): Future[List[B]] =
    l.foldLeft(Future(List.empty[B])) {
      (previousFuture, next) =>
        for {
          previousResults <- previousFuture
          next <- fn(next)
        } yield previousResults :+ next
    }

  def doubleFuture(i: Int) = Future {
    println(s"Processing for $i")
    Thread.sleep(Random.nextInt(Random.nextInt(500)))
    println(s"Completed for $i")
    i * 2
  }

  def generateList(): List[Int] = {
    (1 to 10).toList
  }
}
