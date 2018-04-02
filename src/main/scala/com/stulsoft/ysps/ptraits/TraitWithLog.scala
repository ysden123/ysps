package com.stulsoft.ysps.ptraits

import java.util.logging.Logger

/**
  * @author Yuriy Stul
  * @since 4/1/2018
  */
trait TraitWithLog {
private val logger:Logger  = Logger.getLogger(getClass.getName)
  def makeLog(): Unit ={
    logger.info("First log")
    logger.info(s"getClass.getSimpleName=${getClass.getSimpleName}")
  }
}
