package com.stulsoft.ysps.pexit

/**
  * @author Yuriy Stul
  * @since 4/5/2018
  */
object OnExit1 extends App {
  Runtime.getRuntime.addShutdownHook(new Thread() {
    override def run(): Unit = {
      println("On exit")
    }
  })

  new Thread(){
    override def run(): Unit = {
      println("Working...")
//      Thread.sleep(10000)
      Thread.sleep(1000)
      throw new RuntimeException("test")
    }
  }.start()
}
