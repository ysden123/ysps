/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.precursion

import scala.annotation.tailrec

/**
  * [[https://oldfashionedsoftware.com/2008/09/27/tail-recursion-basics-in-scala/ Tail-Recursion Basics In Scala]]
  *
  * @author Yuriy Stul
  */
object TailAndNoTailRecursion extends App {

  test(List(1, 2, 3))
  test(List(Symbol("a"), Symbol("b"), Symbol("c"), Symbol("d")))

  /**
    * Test runner
    */
  def test[T](list: List[T]): Unit = {
    println(s"(1) $list -> ${listLength1(list)}")
    println(s"(2) $list -> ${listLength2(list)}")
  }

  /**
    * No tail recursion
    *
    * @param list the list
    * @return list length
    */
  def listLength1[T](list: List[T]): Int = {
    if (list == Nil) 0
    else 1 + listLength1(list.tail)
  }

  /**
    * With tail recursion
    *
    * @param list the list
    * @return list length
    */
  def listLength2[T](list: List[T]): Int = {
    @tailrec
    def listLength(currentList: List[T], currentLength: Int): Int = currentList match {
      case Nil => currentLength
      case _ :: tail => listLength(tail, currentLength + 1)
    }

    listLength(list, 0)
  }
}
