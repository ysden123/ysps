package com.stulsoft.ysps.ptry

import java.net.URL

import scala.util.Try

/**
  * Created by Yuriy Stul on 9/17/2016.
  */
object PTry1 {
  def main(args: Array[String]): Unit = {
    println("==>main")
    test1()
    test2()
    test3()
    println("<==main")
  }

  /**
    * Direct analysis
    */
  def test1(): Unit = {
    println("==>test1\nDirect analysis")
    def parseURL(url: String): Try[URL] = Try(new URL(url))

    println(s"""parseURL("http://www.google.com"): ${parseURL("http://www.google.com")}""")
    println(s"""parseURL("error"): ${parseURL("error")}""")
    println("<==test1")
  }

  /**
    * Analysis with map
    */
  def test2(): Unit = {
    println("==>test2\nAnalysis with map")
    def parseURL(url: String): Try[URL] = Try(new URL(url))
    println(s"""parseURL("http://www.google.com").map(_.getHost): ${parseURL("http://www.google.com").map(_.getHost)}""")
    println(s"""parseURL("error").map(_.getHost): ${parseURL("error").map(_.getHost)}""")
    println("<==test2")
  }

  /**
    * Analysis with flatMap
    */
  def test3(): Unit = {
    println("==>test3\nAnalysis with flatMap")
    def parseURL(url: String): Try[URL] = Try(new URL(url))
    println(s"""parseURL("http://www.google.com").flatMap(u=> Try(u.getHost)): ${parseURL("http://www.google.com").flatMap(u => Try(u.getHost))}""")
    println(s"""parseURL("error").flatMap(u=> Try(u.getHost)): ${parseURL("error").flatMap(u => Try(u.getHost))}""")
    println("<==test3")
  }
}
