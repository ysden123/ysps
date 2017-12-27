package com.stulsoft.ysps.util

/**
  * @author Yuriy Stul.
  */
case class BenchmarkResult[T](duration: Long, text: String, value: T) {
  override def toString: String = s"$text: value=$value, duration=$duration"
}
