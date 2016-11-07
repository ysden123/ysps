/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pclass

/**
  * Created by Yuriy Stul on 11/7/2016.
  */
class Container2 private(val p1:Int) {

}

object Container2 {
  def apply(p1: Int): Container2 = {
    val c = new Container2(p1)
    c
  }
}

