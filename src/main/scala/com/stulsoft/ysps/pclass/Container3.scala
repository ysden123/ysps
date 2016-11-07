/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pclass

import scala.util.Random

/**
  * Created by Yuriy Stul on 11/7/2016.
  */
class Container3  private(val p1:Int) {

}

object Container3 {
  def apply(): Container3 = {
    val c = new Container3(Random.nextInt(100))
    c
  }
}
