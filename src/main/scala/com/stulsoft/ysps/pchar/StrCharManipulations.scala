/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pchar

/** String and character manipulations.
  *
  * @author Yuriy Stul
  */
object StrCharManipulations extends App {
  test01("12345")
  test01("abcde")

  def test01(s:String): Unit = {
    println(s"$s -> characters: ${s.map(c => (c + 1).toChar)}")
  }

  def test02(s:String, f: (String)=> String): Unit ={

  }
}
