/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pio

import java.io.File
import java.net.URL
import java.nio.file.{Path, Paths}

/**
  * @author Yuriy Stul
  */
object ReadProperties extends App {
  val dir = "file:///C:/configuration/panel/development/app_customer.properties"
  val fn=new File(dir).toURI.toURL
  println(s"fn: $fn")

  val fn2=new File(dir).toURI
  println(s"fn2: $fn2")

  val fn3=new File(dir).getAbsolutePath
  println(s"fn3: $fn3")

  val fn4=new File(dir)
  println(s"fn4: $fn4")

  val f=fn4.getAbsoluteFile
  println(s"f: $f")

  val url = new URL(dir)
  val strem=url.openStream()


}
