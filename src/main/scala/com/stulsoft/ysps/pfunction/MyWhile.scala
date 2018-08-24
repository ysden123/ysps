/*
 * Copyright (c) 2018. Yuriy Stul
 */

package com.stulsoft.ysps.pfunction

/** Playing with "call by name"
  *
  * See [[https://wordpress.com/read/blogs/126706510/posts/435 Functions Can Have Multiple Parameter Groups]]
  *
  * @author Yuriy Stul
  */
object MyWhile extends App {
  var i = 0

  def myWhileLoop(testCondition: => Boolean)(blockCode: => Unit): Unit = {
    while (testCondition)
      blockCode
  }

  myWhileLoop(i < 5) {
    println(s"i=$i")
    i += 1
  }
}
