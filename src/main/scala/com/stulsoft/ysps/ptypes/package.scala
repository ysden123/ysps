/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps

/**
  * @author Yuriy Stul
  */
package object ptypes {

  class Animal {
    val sound = "rustle"
  }

  class Bird extends Animal {
    override val sound: String = "call"
  }

  class Chicken extends Bird {
    override val sound: String = "cluck"
  }

}
