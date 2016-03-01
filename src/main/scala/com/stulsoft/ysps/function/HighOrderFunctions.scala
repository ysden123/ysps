/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.function

import scala.math._

/**
 * High order functions.
 *
 * @author Yuriy Stul
 *
 */
object HighOrderFunctions {
	def main(args: Array[String]): Unit = {
		println("==>main")
		// Store a number.
		val num = 123.4

		// Store a function.
		val func1 = ceil _
		val v1 = func1(num)
		println(s"v1=$v1")

		val func2 = (x) => ceil(x)
		val v2 = func2(num)
		println(s"v2=$v2")

		val func3 = (x: Double) => x * 2
		val v3 = func3(num)
		println(s"v3=$v3")

		// Pass a function as parameter of a method
		funcTest(func3)

		// Anonymous function
		funcTest2((x: Double) => "\"" + (x * 3).toString + "\"")

		// Method that return a function.
		
		// 'five' is a function
		val five = mulBy(5) 
		println(s"five(6)=${five(6)}")
		
		println("<==main")
	}

	/**
	 * High order function funcTest.
	 *
	 * @param f a function with argument of type Double and result of type Double
	 */
	def funcTest(f: (Double) => Double): Unit = {
		println("==>funcTest")

		println(f(321))

		println("<==funcTest")
	}

	/**
	 * High order function funcTest2.
	 *
	 * @param f a function with argument of type Double and result of type String
	 */
	def funcTest2(f: (Double) => String): Unit = {
		println("==>funcTest2")

		println(f(321))

		println("<==funcTest2")
	}

	/**
	 * Returns a multiply function.
	 *
	 * @param factor the factor
	 * @return the multiply function
	 */
	def mulBy(factor: Double) = (x: Double) => factor * x
}