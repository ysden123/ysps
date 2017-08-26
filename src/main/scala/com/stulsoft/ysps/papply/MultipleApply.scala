/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.papply

/** Playing with multiple apply
  *
  * @author Yuriy Stul
  */
object MultipleApply extends App {

  val n1 = Node("1")
  val n2 = Node("1", "2")
  val n3 = Node("1", "2", "3")

  println(s"n1: $n1")
  println(s"n2: $n2")
  println(s"n3: $n3")

  class Node(val value: String, val left: String, val right: String) {
    override def toString: String = s"value: $value, left: $left, right: $right"
  }

  object Node {
    def apply(value: String): Node = new Node(value, "", "")

    def apply(value: String, left: String): Node = new Node(value, left, "")

    def apply(value: String, left: String, right: String): Node = new Node(value, left, right)
  }

}
