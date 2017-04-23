/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pcollection

case class User(casino: String, username: String)

/**
  * Demonstrates usage of groupingBy for converting collection to map[Key,Collection]
  *
  * @author Yuriy Stul
  */
object Collection2Map extends App {
  val c1 = Seq(User("casino1", "user1"), User("casino1", "user2"), User("casino2", "user3"))

  val m1 = c1.groupBy(user => user.casino)
  println(m1) // ==> Map(casino1 -> List(User(casino1,user1), User(casino1,user2)), casino2 -> List(User(casino2,user3)))
}
