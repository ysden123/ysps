package com.stulsoft.ysps

import java.util.concurrent.atomic.AtomicLong

import scala.concurrent.Future

/**
  * @author Yuriy Stul
  * @since 4/22/2018
  */
object PStats1 extends App {

  import scala.concurrent.ExecutionContext.Implicits.global

  /**
    * Without threads
    */
  def test1(): Unit = {
    println("==>test1")
    (1 to 100).foreach(i => {
      val (total, time) = _Statistics.addAndGetSynchronized(i)
      println(s"total=$total, time=$time")
    })
    println("<==test1")
  }

  /**
    * With threads and sync
    */
  def test2(): Unit = {
    println("==>test2")
    (1 to 100).foreach(i => {
      Future {
        Thread.sleep(500)
        val (total, time) = _Statistics.addAndGetSynchronized(i)
        println(s"total=$total, time=$time")
      }
    })
    Thread.sleep(10000)
    println("<==test2")
  }

  /**
    * With threads and without sync
    */
  def test3(): Unit = {
    println("==>test3")
    (1 to 100).foreach(i => {
      Future {
        Thread.sleep(500)
        val (total, time) = _Statistics.addAndGet(i)
        println(s"total=$total, time=$time, now=${System.nanoTime()}")
      }
    })
    Thread.sleep(10000)
    val (total, time) = _Statistics.get
    println(s"last: total=$total, time=$time, now=${System.nanoTime()}")
    println("<==test3")
  }

  //  test1()
//  test2()
  test3()

  private object _Statistics {
    private val start: Long = System.nanoTime()
    private val sent: AtomicLong = new AtomicLong(0L)

    def addAndGet(batch: Long): (Long, Double) = {
      val amountTotal = sent.addAndGet(batch)
      (amountTotal, 1000000.0 * amountTotal / (System.nanoTime() - start))
    }

    def addAndGetSynchronized(batch: Long): (Long, Double) = {
      sent.synchronized {
        val amountTotal = sent.addAndGet(batch)
        (amountTotal, 1000000.0 * amountTotal / (System.nanoTime() - start))
      }
    }

    def get: (Long, Double) = {
      val amountTotal = sent.get()
      (amountTotal, 60000.0 * amountTotal / (System.currentTimeMillis() - start))
    }
  }

}
