/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pselftypeannotation

/**
  * @see [[https://wordpress.com/read/feeds/64906696/posts/1436965299 Self type Annotations in Cake Pattern]]
  * @author Yuriy Stul
  */
object Example2 {

  def main(args: Array[String]): Unit = {
    println("==>main")
    val s = new Service with ReadWriteDB
    println(s"s.read(): ${s.read()}")
    println(s"s.write(): ${s.write()}")
    println("<==main")
  }

  trait ReadWrite {
    def read(): String = "data from file"

    def write(): String = "data written to file"
  }

  trait ReadWriteDB extends ReadWrite {
    override def read(): String = "data from DB"

    override def write(): String = "data written to DB"
  }

  class Service {
    this: ReadWrite =>
    def reading: String = read()

    def writing: String = write()
  }

}
