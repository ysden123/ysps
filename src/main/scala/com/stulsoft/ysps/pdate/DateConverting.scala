/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pdate

//import java.sql.Date
//import java.text.DateFormat
import java.text.{DateFormat, SimpleDateFormat}
import java.util.{Date, SimpleTimeZone, TimeZone}

/** Converting datetime from Salesforce time
  *
  * @author Yuriy Stul
  */
object DateConverting extends App {

  fromSFDate()

  def fromSFDate(): Unit = {
    println("==>fromSFDate")

    val df1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val date1 = df1.parse("2019-07-13 23:22:57.104345")
    println(s"date1 = $date1")

    val df2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    println(s"df2.getTimeZone = ${df2.getTimeZone}")
    val date2 = df2.parse("2019-07-21T01:28:21.817442-07:00")
    println(s"date2 = $date2")

    val df3 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
//    df2.setTimeZone(TimeZone.getTimeZone("UTC+07"))
    df3.setTimeZone(new SimpleTimeZone(-7, "UTC"))
    println(s"df3.getTimeZone = ${df3.getTimeZone}")
    val date3 = df3.parse("2019-07-21T01:28:21.817442")
    println(s"date3 = $date3, df3.format(date3) = ${df3.format(date3)}")
    println("<==fromSFDate")

    val df4 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    df4.setTimeZone(TimeZone.getTimeZone("UTC-07"))
    println(s"df4.getTimeZone = ${df4.getTimeZone}")
    val date4 = df4.parse("2019-07-21T01:28:21.817442")
    println(s"date4 = $date4, df4.format(date4) = ${df4.format(date4)}")

    val df5 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
    val date5 = df5.parse("2019-07-21T09:51:49.993287+00:00")
    println(s"date5 = $date5, df5.format(date5) = ${df5.format(date5)}")




    println("<==fromSFDate")
  }
}
