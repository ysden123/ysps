/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.ppromise

import com.typesafe.scalalogging.LazyLogging

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.{Future, Promise}

/**
  * Created by Yuriy Stul on 10/29/2016.
  */
object PromiseExample3 extends App with LazyLogging {

  /**
    * Does a work and creates a failure
    *
    * @return Future[String] Success(result); Failure(exception)
    */
  def process(): Future[String] = {
    //Initialize a promise
    val promise = Promise[String]()

    // Do a work asynchronously
    Future {
      Thread.sleep(1000)

      // Mark work as failed
      promise failure new RuntimeException("test error")
    }

    // Return future
    promise.future
  }

  logger.info("Main started")

  val p = process()
  p foreach { r => logger.info(r) }

  Thread.sleep(1500)

  logger.info("Main ended")
}
