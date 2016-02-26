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

		println()

		// Empty logging
		println("Empty logging")
		val t21 = new TestClass2(17)

		println()

		// With logging
		println("Console logging")
		val t22 = new TestClass2(18) with ConsoleLogger;
		
		println()
		
		// With file logging
		println("'File' logging")
		val t23 = new TestClass2(19) with FileLogger;
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

/**
 * Declare interface Logged with empty implementation of log function.
 *
 * @author Yuriy Stul
 *
 */
trait Logged {
	def log(message: String): Unit = {}
}

/**
 * Console implementation of the logger.
 *
 * @author Yuriy Stul
 *
 */
trait ConsoleLogger extends Logged {
	override def log(message: String): Unit = { println(message) }
}

/**
 * 'File' implementation of the logger.
 *
 * @author Yuriy Stul
 *
 */
trait FileLogger extends Logged {
	override def log(message: String): Unit = { println(s"(file): $message") }
}

/**
 * Test class with logging (Logged).
 *
 * @author Yuriy Stul
 *
 */
class TestClass2(val a: Int) extends Logged {
	log(s"a = $a")
}