/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pconcurrency

import java.util.concurrent.atomic.{AtomicBoolean, AtomicInteger}

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{Await, Future}
import scala.util.Random

/**
  * Playing with notify/wait (producer/consumer)
  *
  * @author Yuriy Stul
  */
object ProducerConsumer3 extends App with LazyLogging {

  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration._

  val maxCount = 5
  val count: AtomicInteger = new AtomicInteger
  val continue: AtomicBoolean = new AtomicBoolean(true)

  def run(): Unit = {
    logger.info("==>run")
    // Start consumer
    val consumerFuture = Future {
      consumer()
    }

    // Start producer
    Future {
      producer()
    }

    Thread.sleep(10 * 1000)

    // Signal to complete process
    logger.info("Set continue to false")
    continue.getAndSet(false)
    count.synchronized {
      count.notify()
    }
    // Limit the test execution with 10 seconds
    try {
      logger.info("Wait consumerFuture")
      Await.ready(consumerFuture, 10.seconds)
    } catch {
      case _: Exception => None
    }
    logger.info("<==run")
  }

  def producer(): Unit = {
    logger.info("==>producer")
    while (continue.get()) {
      count.synchronized {
        if (count.get() > maxCount) {
          count.wait()
        }
        logger.info("Add message")
        count.getAndIncrement()
        count.notify()
      }
      val delay = Random.nextInt(1001)
      logger.info(s"Delay $delay ms")
      Thread.sleep(delay)
    }
    logger.info("<==producer")
  }

  def consumer(): Unit = {
    logger.info("==>consumer")
    while (continue.get() || count.get() > 0) {
      if (continue.get()) {
        count.synchronized {
          count.wait()
        }
      }

      logger.info(s"Consume message ${count.get()}")
      val delay = Random.nextInt(1001)
      logger.info(s"Delay $delay ms")
      Thread.sleep(delay)
      count.getAndDecrement()
    }
    logger.info("<==consumer")
  }

  logger.info("==>main")
  run()
  logger.info(s"Final count is ${count.get()}")
  logger.info("<==main")
}
