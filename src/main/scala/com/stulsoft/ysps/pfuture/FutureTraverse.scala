package com.stulsoft.ysps.pfuture

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Random

/** Playing with Future.traverse
  *
  * @author Yuriy Stul.
  */
object FutureTraverse extends App with LazyLogging {
  val durations: List[Long] = List.fill(5)(Random.nextInt(1000))
  test1()
  test2()

  import scala.concurrent.ExecutionContext.Implicits.global

  /**
    * Without exception
    *
    * @param t duration
    * @return nothing
    */
  def task1(t: Long): Future[Unit] = Future {
    logger.info("task1 started with {}", t)
    Thread.sleep(t)
    logger.info("task1 finished with {}", t)
  }

  /**
    * With exception
    *
    * @param t duration
    * @return nothing
    */
  def task2(t: Long): Future[Unit] = Future {
    logger.info("task2 started with {}", t)
    Thread.sleep(t)
    if (Random.nextBoolean()) {
      logger.error("Throw exception for {}", t)
      throw new RuntimeException("test exception")
    }
    logger.info("task2 finished with {}", t)
  }

  /**
    * Executes tasks without exceptions
    */
  def test1(): Unit = {
    logger.info("test1(): Start")
    Await.result(Future.traverse(durations)(t => task1(t)), Duration.Inf)
    logger.info("test1(): Finish")
  }

  /**
    * Executes tasks with exceptions. Uses recovery function.
    */
  def test2(): Unit = {
    logger.info("test2(): Start")
    Await.result(Future.traverse(durations)(t => task2(t)).recover { case _: Throwable => }, Duration.Inf)
    logger.info("test2(): Finish")
  }
}
