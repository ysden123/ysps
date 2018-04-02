package com.stulsoft.ysps.ptraits

/**
  * @author Yuriy Stul
  * @since 4/1/2018
  */
object TraitWithLogRunner extends App {
  val t1 = new TraitWithLogImpl1
  val t2 = new TraitWithLogImpl2
  t1.makeLog()
  t2.makeLog()
}
