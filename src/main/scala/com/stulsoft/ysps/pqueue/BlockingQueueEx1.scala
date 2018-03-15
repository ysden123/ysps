package com.stulsoft.ysps.pqueue

import java.util.concurrent.ArrayBlockingQueue

/** Playing with BlockingQueue
  *
  * @author Yuriy Stul
  * @since 3/15/2018
  */
object BlockingQueueEx1 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    try {
      val maxSize = 1
      val queue = new ArrayBlockingQueue[String](maxSize)
      var rslt = queue.offer("text 1")
      println(s"(1) rslt = $rslt, queue.size()=${queue.size()}")
      rslt = queue.offer("text 2")
      println(s"(2) rslt = $rslt, queue.size()=${queue.size()}")
      rslt = queue.offer("text 3")
      println(s"(3) rslt = $rslt, queue.size()=${queue.size()}")
    }
    catch {
      case e: Exception => println(s"Exception: ${e.getMessage}")
    }

    println("<==test1")
  }
}
