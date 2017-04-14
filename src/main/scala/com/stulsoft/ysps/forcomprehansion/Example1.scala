/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.forcomprehansion

/**
  * See [[https://gist.github.com/loicdescotte/4044169 Scala for comprehension translation helper]]
  *
  * @author Yuriy Stul
  */
object Example1 extends App {
  val books = generateBooks()
  val r1 = for {
    book <- books
    if book.author endsWith "2"
  } yield book.title
  val r2 = books.withFilter(book => book.author endsWith "2").map(book => book.title)
  println(s"books: $books")
  println(s"r1: $r1")
  println(s"r2: $r2")

  def generateBooks(): Seq[Book1] = {
    (1 to 3).map(i => Book1(s"author$i", s"title$i"))
  }
}

case class Book1(author: String, title: String)

