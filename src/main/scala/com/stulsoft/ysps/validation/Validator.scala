/*
 * Copyright (c) 2021. StulSoft
 */

package com.stulsoft.ysps.validation

import scala.collection.mutable.ListBuffer

/**
 * @author Yuriy Stul
 */
class Validator[T](anObject: T) {
  val validators = new ListBuffer[(T => Boolean, String)]

  def withValidator(predicate: T => Boolean, error: String): Validator[T] = {
    validators += ((predicate, error))
    this
  }

  def validate(): Option[String] = {
    var error = if (anObject == null) Option("An object is null") else Option.empty[String]

    validators.iterator
      .takeWhile(_ => error.isEmpty)
      .foreach { case (predicate, errorMsg) =>
        error = if (predicate(anObject)) Option(errorMsg) else Option.empty
      }

    error
  }
}

object Validator {
  def apply[T](anObject: T): Validator[T] = {
    new Validator(anObject)
  }
}