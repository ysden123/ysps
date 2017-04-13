/*
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.function

/**
 * Call by name and call by value.
 *
 * @author Yuriy Stul
 *
 */
object CallByName {
  def main(args: Array[String]): Unit = {
    println("==>main")

    println()
    println("callByName(nano()):")
    println(s"callByName(nano()) = ${callByName(nano())}")

    println()
    println("callByName(123):")
    println(s"callByName(123) = ${callByName(123)}")

    println()
    println("callByName(f(7)):")
    println(s"callByName(f(7)) = ${callByName(f(7))}")

    println()
    println("callByValue(nano()):")
    println(s"callByValue(nano()) = ${callByValue(nano())}")

    println("<==main")
  }

	/**
	 * A function for test.
	 *
	 * @return the time in nanoseconds
	 */
  def nano(): Long = {
		println("==>nano")
		println("<==nano")
		System.nanoTime
	}

	/**
	 * Ordinary function
	 * @param x parameter
	 * @return x * 3
	 */
  def f(x: Int): Int = {
		println("==>f")
		println("<==f")
		x * 3
	}

	/**
	 * Function with a parameter by name.
	 *
	 * Each time, when the function uses the parameter, the function calls the parameter like a function.
	 *
	 * @param t specifies a parameter; it may be either value of type Long, e.g. 123, or a function with type Long, e.g. nano().
	 * @return the value of parameter: result of call the t, if the t is a function; same as was in call of function, if the t is a value.
	 */
  def callByName(t: => Long): Long = {
		println("==>callByName")
		println(s"(1) Parameter: $t")
		println(s"(2) Parameter: $t")
		println("<==callByName")
		t
	}

	/**
	 * Function with an ordinary parameter.
	 * @param t specifies the parameter of type Long.
	 * @return the value of parameter: same as was in call of function.
	 */
  def callByValue(t: Long): Long = {
		println("==>callByValue")
		println(s"(1) Parameter: $t")
		println(s"(2) Parameter: $t")
		println("<==callByValue")
		t
	}
}