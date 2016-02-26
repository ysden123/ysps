/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.traits

import java.lang.StackTraceElement

/**
 * Playing with traits - trait for logging.
 *
 * @author Yuriy Stul
 *
 */
object LoggingTrait {

	def main(args: Array[String]): Unit = {
		println("==>main")
		val t = new TestClass(15)
		t.foo(25)
		
		val t1 = new TestClass1(16)
		t1.foo()
		println("<==main")
	}
}

/**
 * Logging trait.
 *
 * @author Yuriy Stul
 *
 */
trait Log {
	def log(message: String) = println(message)
	def log2(message: String): Unit = {
		val stackTraceElements: Array[StackTraceElement] = Thread.currentThread().getStackTrace()
		println(s"Class: ${stackTraceElements(3).getClassName}")
		println(s"Method: ${stackTraceElements(3).getMethodName}")
		println(s"Message: $message")
	}
}

/**
 * Test class. Has constructor only.
 *
 * @author Yuriy Stul
 *
 */
class TestClass(val a1: Int) extends Log {
	log(s"a1=$a1")

	def foo(i: Int): Unit = {
		log2(s"i=$i")
	}
}

/**
 * Just a trait
 * 
 * @author Yuriy Stul
 *
 */
trait T123 {
	def foo(): Unit
}

/**
 * Test class for T123 with Log
 * 
 * @author Yuriy Stul
 *
 */
class TestClass1(val a1: Int) extends T123 with Log {
	log2("a1 = " + a1)
	def foo(): Unit = {
		println("The foo")
		log2("The foo")
	}
}