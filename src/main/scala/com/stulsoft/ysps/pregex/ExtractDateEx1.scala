/*
 * Copyright (c) 2020. Yuriy Stul
 */

package com.stulsoft.ysps.pregex

/**
 * @author Yuriy Stul
 */
object ExtractDateEx1 extends App {
//  test1()
//  test2()
  test3()
  def test1(): Unit = {
    println("==>test1")
    val srcDateText = "2020-11-06T16:28:00+02:00"
    val date = """(.*)T(.*)+""".r
    srcDateText match {
      case date(d, t) =>
        println(s"d=$d, t=$t")
      case _ =>
        println("Nothing")
    }
  }
  def test2(): Unit = {
    println("==>test2")
//    val srcDateText = "2020-11-06T16:28:00ABC02:00"
    val srcDateText = "2020-11-06T16P28P00ABC02:00"
//    val srcDateText = "2020-11-06T16:28:00"
    val date = """(.*)T(\d\dP\d\dP\d\d)""".r
    srcDateText match {
      case date(d, t) =>
        println(s"d=$d, t=$t")
      case _ =>
        println("Nothing")
    }
  }

  def test3(): Unit ={
    println("==>test3")
    val dateRegex = """([0-9]{4}-[0-9]{2}-[0-9]{2})"""
    val timeRegex = """([0-9]{2}:[0-9]{2}:[0-9]{2})"""
    val suffix = """(.*)"""
    val date = (dateRegex + "T" + timeRegex + suffix).r
    val srcDateText = "2020-11-06T16:28:00+02:00"
    srcDateText match {
      case date(d, t, _) =>
        println(s"d=$d, t=$t")
      case _ =>
        println("Nothing")
    }
  }
}
