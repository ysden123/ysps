/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pimlicit

/**
  * Created by Yuriy Stul on 11/8/2016.
  */
object StringUtils {

  /**
    * Demonstrates implicit class
    *
    * @see [[ImplicitClassTest]]
    * @param s a string
    */
  implicit class ImplicitClass(s: String) {

    /**
      * Increments each character
      *
      * @return incremented string
      */
    def increment: String = s.map(c => (c + 1).toChar)
  }

}

