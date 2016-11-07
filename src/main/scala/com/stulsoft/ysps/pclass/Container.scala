/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pclass

import com.typesafe.scalalogging.LazyLogging

/**
  * Created by Yuriy Stul on 11/7/2016.
  */
class Container private(val p1: Int) {
}

object Container {
  def apply(p1: Int): Container = {
    val c = new Container(p1)
    c
  }
}

