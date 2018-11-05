/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pio

import java.net.URL
import java.util.Properties

/**
  * @author Yuriy Stul
  */
object ReadProperties extends App {
  //  c:\work\test\app.properties
  val dir = "file:///C:/work/test/app.properties"
  var url = new URL(dir)

  val props = new Properties()
  props.load(url.openStream())
  props.forEach { (name, value) => println(s"name=$name, value=$value") }
}
