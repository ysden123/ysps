/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.plist

/**
  * @see [[http://aperiodic.net/phil/scala/s-99/p01.scala Find the last element of a list]]
  * @author Yuriy Stul
  */
object P001 extends App {
  // There are several ways to solve this problem.  If we use builtins, it's very
  // easy.
  def lastBuiltin[A](ls: List[A]): A = ls.last

  // The standard functional approach is to recurse down the list until we hit
  // the end.  Scala's pattern matching makes this easy.
  def lastRecursive[A](ls: List[A]): A = ls match {
    case h :: Nil => h
    case _ :: tail => lastRecursive(tail)
    case _ => throw new NoSuchElementException
  }

  println(s"lastBuiltin(List(1, 1, 2, 3, 5, 8)): ${lastBuiltin(List(1, 1, 2, 3, 5, 8))}")
  println(s"lastRecursive(List(1, 1, 2, 3, 5, 8)): ${lastRecursive(List(1, 1, 2, 3, 5, 8))}")
}
