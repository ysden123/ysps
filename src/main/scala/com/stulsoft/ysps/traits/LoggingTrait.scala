/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.traits

/**
 * Playing with traits - trait for logging.
 *
 * @author Yuriy Stul
 *
 */
object LoggingTrait {

	def main(args: Array[String]): Unit = {
		println("==>main")
		val t1 = new TestClass(15)
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
}

/**
 * Test class. Has constructor only.
 *
 * @author Yuriy Stul
 *
 */
class TestClass(val a1: Int) extends Log {
	log(s"a1=$a1")
}