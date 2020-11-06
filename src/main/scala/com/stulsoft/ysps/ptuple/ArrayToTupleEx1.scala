/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.ysps.ptuple

import scala.io.Source

/**
 * @author Yuriy Stul
 */
private object ArrayToTupleEx1 extends App {
  test1()
  test2()

  def test1(): Unit = {
    println("==>test1")

    val t: Array[String] = Array("sss1", "sss2")
    val tt = t match {
      case Array(s1, s2) => (s1, s2)
    }

    println(s"tt=$tt")
  }

  def test2(): Unit = {
    println("==>test2")

    val s = Source.fromResource("dataForArrayToTuple.txt")
    val result = s.getLines()
      .map(line => line.split(": "))
      .filter {
        case Array(_, _) => true
        case _ => false
      }
      .map(a => (a(0), a(1)))
      .toSeq
    s.close()
    println(s"result: $result")
  }
}
