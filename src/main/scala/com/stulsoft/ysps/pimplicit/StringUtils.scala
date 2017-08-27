/*
 * Copyright (c) 2016. StulSoft, Yuriy Stul
 */

package com.stulsoft.ysps.pimplicit

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

    /** Decrements eazch character
      *
      * @return decremented string
      */
    def decrement: String = s.map(c => (c - 1).toChar)

    /** Replaced each character with replacement
      *
      * @param r replacement character
      * @return replaced string
      */
    def replacement(r:Char):String = s.map(_ => r)
  }

}

