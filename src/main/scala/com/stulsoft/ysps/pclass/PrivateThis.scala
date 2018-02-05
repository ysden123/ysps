/*
   Created by Yuriy Stul 2018
*/
package com.stulsoft.ysps.pclass

/**
  * @see [[https://blog.codacy.com/difference-between-private-and-private-this-8811f7061bbb Difference between private and private[this]?]]
  */
class PrivateThis {

  class FooWithError {
    private[this] val i = 2

    /**
      * With error
      */
    def printI(foo: FooWithError): Unit = {
      // error: println(this.i + foo.i)
    }
  }

  class FooWithoutError {
    private val i = 2

    /**
      * Without error
      */
    def printI(foo: FooWithoutError): Unit = {
      println(this.i + foo.i)
    }
  }

}
