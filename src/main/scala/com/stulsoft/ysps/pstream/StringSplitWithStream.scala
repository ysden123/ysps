/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pstream

case class DevRevenue(dev: String, revenue: String)

case class UserDevRevenues(user: String, devRevenues: Map[String, String])

case class UserDevRevenueTexts(user: String, devRevenueTexts: String)

/**
  * @author Yuriy Stul
  */
object StringSplitWithStream extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val source = "a{DEL1}b1{DEL2}c1{DEL3}b2{DEL2}c2{DEL4}"

    source.split("\\{DEL4\\}")
      .map(del4S => del4S.split("\\{DEL1\\}"))
      .filter(del1S => del1S.length == 2)
      .map(del1S => UserDevRevenueTexts(del1S(0), del1S(1)))
      .map(userDevRevenueTexts => {
        val devRevenues = userDevRevenueTexts
          .devRevenueTexts
          .split("\\{DEL3\\}")
          .map(item => item.split("\\{DEL2\\}"))
          .filter(items => items.length == 2)
          .map(items => DevRevenue(items(0), items(1)))
          .map(devRevenue => devRevenue.dev -> devRevenue.revenue)
          .toMap

        UserDevRevenues(userDevRevenueTexts.user, devRevenues)
      })
      .foreach(println)

    println("<==test1")
  }
}
