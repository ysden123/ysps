/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pconcurrency

import java.util.concurrent.atomic.AtomicInteger

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.{Await, Future}
import scala.util.Random

/**
  * Playing with notify/wait (producer/consumer)
  *
  * @author Yuriy Stul
  */
object ProducerConsumer1 extends App with LazyLogging {

  import scala.concurrent.ExecutionContext.Implicits.global
  import scala.concurrent.duration._

  val maxCount = 5
  val count: AtomicInteger = new AtomicInteger

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

    // Limit the test execution with 10 seconds
    try {
      Await.ready(consumerFuture, 10.seconds)
    } catch {
      case _: Exception => None
    }
    logger.info("<==run")
  }

  def producer(): Unit = {
    logger.info("==>producer")
    while (true) {
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
  }

  def consumer(): Unit = {
    logger.info("==>consumer")
    while (true) {
      count.synchronized {
        count.wait()
      }
      logger.info(s"Consume message ${count.get()}")
      val delay = Random.nextInt(1001)
      logger.info(s"Delay $delay ms")
      Thread.sleep(delay)
      count.getAndDecrement()
    }
  }

  logger.info("==>main")
  run()
  logger.info(s"Final count is ${count.get()}")
  logger.info("<==main")
}
