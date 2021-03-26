/*
 * Copyright (c) 2020. StulSoft
 */

package com.stulsoft.ysps.pcollection.mutable

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

/**
 * @author Yuriy Stul
 */
object BufferExc1 extends App {
  arrayBufferEx1()
  listBufferEx1()

  def arrayBufferEx1(): Unit = {
    println("==>arrayBufferEx1")
    val ab = ArrayBuffer[Int]()
    ab += 1
    ab += 2
    ab += 3
    ab += 4
    println(ab)
  }

  def listBufferEx1(): Unit = {
    println("==>listBufferEx1")
    val ab = ListBuffer[Int]()
    ab += 1
    ab += 2
    ab += 3
    ab += 4
    println(ab)
  }
}
