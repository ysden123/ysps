/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pforcomprehansion

/**
  * For with comprehension is more shorter (concise) and more clear (readable)
  *
  * See [[https://gist.github.com/loicdescotte/4044169 Scala for comprehension translation helper]]
  *
  * @author Yuriy Stul
  */
object Example2 extends App {
  val books = generateBooks()
  val r1 = for {
    book <- books
    author <- book.authors
    if author endsWith "22"
  } yield book.title

  // _ is authtor
  // function flatMap returns only book where at lease one author ends with "22"
  val r2 = books.flatMap(book =>
    book.authors.withFilter(author => author endsWith "22").map(_ => book.title)
  )

  def generateBooks(): Seq[Book2] = {
    (1 to 3).map(i => {
      Book2((1 to 3).map(j => s"author$i$j"), s"title$i")
    })
  }

  /*
    val r2 = books.flatMap(book => book.authors.withFilter(author => author endsWith "22").map(author =>{
      println(s"author is $author")
      book.title
    } ))
  */
  println(s"books: $books")
  println(s"r1: $r1")
  println(s"r2: $r2")
}

case class Book2(authors: Seq[String], title: String)
