package com.stulsoft.ysps.pcollection

/**
  * Created by Yuriy Stul on 10/8/2016.
  */
object PList extends App {
  println("==>start")
  createList1()
  createList2()
  println("==>end")

  def createList1(): Unit = {
    println("==>createList1")

    val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    println(s"days.getClass.getName is ${days.getClass.getName}")
    // Pattern match
    days match {
      case firstDay :: otherDays =>
        println("The first day of the week is: " + firstDay)
      case List() =>
        println("There don't seem to be any week days.")
    }
    println("<==createList1")
  }

  def createList2(): Unit = {
    println("==>createList2")

    val when = "AM" :: "PM" :: List()
    println(when)
    println("<==createList2")
  }
}
