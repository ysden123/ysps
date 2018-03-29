package com.stulsoft.ysps.ptraits

/**
  * @author Yuriy Stul
  */
trait Trait1 {
  def p1: Int

  def p2: String

  def f1(): String = {
    s"p1=$p1, p2=$p2"
  }
}
