/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.date

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar


/**
  * Date manipulations
  *
  * @author Yuriy Stul
  */
object DateManipulations extends App {
  def extractFromCsv(t: String, delta: Int): Unit = {
    println("==>extractFromCsv")
    println(s"t: $t | delta = $delta ")
    val splits = t.split(",")
    var firstItem = splits.head
    println(s"(1) firstItem=$firstItem")
    firstItem = firstItem.replaceAll(""""""", "")
    println(s"(2) firstItem=$firstItem")
    val d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(firstItem)
    println(s"(3) d1=$d1")


    val d2 = Calendar.getInstance()
    d2.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(firstItem))
    d2.add(Calendar.DATE, delta)
    println(s"(4) d=${new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d2.getTime)}")
    println("<==extractFromCsv")
  }

  def addHours(t: String, delta: Int): Unit = {
    println("==>addHours")
    println(s"t: $t | delta = $delta ")
    val d = Calendar.getInstance()
    d.setTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(t))
    d.add(Calendar.HOUR, delta)
    println(s"d: ${new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(d.getTime)}")
    println("<==addHours")
  }

  def extract2(): Unit = {
    println("==>extract2")
    var t = "Mar 26, 2017 01:59 PM"
    var d = new SimpleDateFormat("MMM dd, yyyy hh:mm a").parse(t)
    println(s"t: $t  d: $d")

    t = "Mar 26, 2017 01:59 AM"
    d = new SimpleDateFormat("MMM dd, yyyy hh:mm a").parse(t)
    println(s"t: $t  d: $d")
    println("<==extract2")
  }

  def testLocalDateTime(): Unit ={
    println("==>testLocalDateTime")
    val t = "Mar 26, 2017 01:59 PM"
    val d = LocalDateTime.parse(t, DateTimeFormatter.ofPattern("MMM dd, yyyy hh:mm a"))
    println(s"t: $t  d: $d, date: ${d.toLocalDate}, plus hours: ${d.plusHours(10)}")
    println("<==testLocalDateTime")
  }

  extractFromCsv(""""2015-03-03 12:12:13",123,text""", 2)
  extractFromCsv(""""2015-03-30 12:12:13",123,text""", 2)
  extractFromCsv(""""2015-03-03 12:12:13",123,text""", 30)
  extractFromCsv("""2015-03-30 12:12:13,123,text""", 13)

  addHours("2015-03-03 12:12:13", 5)
  addHours("2015-03-03 12:12:13", 15)
  addHours("2015-03-03 2:12:13", 15)
  addHours("2015-03-03 22:12:13", 15)

  extract2()

  testLocalDateTime
}
