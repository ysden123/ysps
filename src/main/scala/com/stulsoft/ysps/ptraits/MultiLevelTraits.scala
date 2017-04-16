/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.ptraits

/**
 * Demonstrates multiple traits usage.
 *
 * @author Yuriy Stul
 *
 */
object MultiLevelTraits {
  def main(args: Array[String]): Unit = {
    System.out.println("==>main");

    // Sequence of trait execution is Impl2, Impl1, and ConsoleImpl
    val v1 = new TestClassMT(1) with ConsoleImpl with Impl1 with Impl2

    // Sequence of trait execution is Impl1, Impl2, and ConsoleImpl
    val v2 = new TestClassMT(1) with ConsoleImpl with Impl2 with Impl1
    println("<==main")
  }

	/**
	 * Declares a common interface (trait) without an implementation.
	 *
	 * @author Yuriy Stul
	 *
	 */
	trait CommonInterface {
		/**
		 * A method
		 *
		 * @param message the method parameter
		 */
		def foo(message: String) = {}
	}

	/**
	 * The 1st implementation of the CommonInterface
	 *
	 * @author Yuriy Stul
	 *
	 */
	trait Impl1 extends CommonInterface {
		override def foo(message: String) = { super.foo("impl1: " + message) }
	}

	/**
	 * The 2nd implementation of the CommonInterface.
	 *
	 * @author Yuriy Stul
	 *
	 */
	trait Impl2 extends CommonInterface {
		override def foo(message: String) = { super.foo("impl2: " + message) }
	}

	/**
	 * Outputs on console.
	 * @author Yuriy Stul
	 *
	 */
	trait ConsoleImpl extends CommonInterface {
		override def foo(message: String) = { println(message) }
	}

	/**
	 * A test class.
	 *
	 * @author Yuriy Stul
	 *
	 */
	class TestClassMT(val a: Int) extends CommonInterface {
		foo(s"a = $a")
	}
}