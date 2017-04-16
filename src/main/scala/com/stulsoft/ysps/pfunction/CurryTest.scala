/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.pfunction

/**
 * Currying in Scala.
 *
 * See original sources on sites:
 *   - [[http://docs.scala-lang.org/tutorials/tour/currying.html Currying]]
 *   - [[https://github.com/Sergey80/scala-samples/blob/master/lang/src/main/scala/currying/CurryingTest.scala CurryingTest]]
 *
 * @author Yuriy Stul
 *
 */
object CurryTest extends App {
	println("==>CurryTest"); {
		// From http://docs.scala-lang.org/tutorials/tour/currying.html
		/*
		 * A filter method.
		 *
		 * @param xs collection of elements integer type.
		 * @param p predicate function
		 * @return collection of filtered elements.
		 */
		def filter(xs: List[Int], p: Int => Boolean): List[Int] =
			if (xs.isEmpty) xs
			else if (p(xs.head)) xs.head :: filter(xs.tail, p)
			else filter(xs.tail, p)

		/*
		 * Curry function; checks, is whether x by modulo n equal 0.
		 *
		 * @param n first parameter
		 * @param x second parameter
		 * @return true, if x by modulo n is 0.
		 */
		def modN(n: Int)(x: Int) = ((x % n) == 0)

		//	List of integer items
		val nums = List(1, 2, 3, 4, 5, 6, 7, 8)

		println(filter(nums, modN(2)))

		println(filter(nums, modN(3)))
	}

	println

	println; {
		// From https://github.com/Sergey80/scala-samples/blob/master/lang/src/main/scala/currying/CurryingTest.scala
		/*
		 * The difference between a Function that returns a function and Currying.
		 * Currying - is a function that expects parameters but if those are missed -
		 * returns another function where (rest of) those params are expected to be passed to than new function afterwards.
		 * To be able to miss some of parameters we have to use "_".
		 */
		{ // 1. not Currying - it just returns a anonymous function with predefined body/algorithm
			def add1(a: Int) = { b: Int => a + b } // use anonymous function, that expect b:Int as param and use "a" from parent-function
			// 1.1
			println("1.1: " + add1(5)(6))

			// 1.2
			//add1(5)_  // can not be treated as 'partially applied function',
			//            // because there is no 2nd parameter defined, so there is nothing to omit then

			val f = add1(5) // only one param is used. no need to treat this as 'partially applied function',
			// no need to pass "_", does not require 2nd parameter passed (see next example)
			println("1.2.0: " + f)
			println("1.2.1: " + f(6))
			println("1.2.2: " + f(7))
		}

		println()

		{ // 2. Currying - it does not return a function - it returns an Int result.
			// It expects 2nd parameter to be passed,
			// but if that is not provided - it returns a function that expects this parameter
			def add2(a: Int)(b: Int) = { a + b }

			// 2.1
			println("2.1: " + add2(5)(6))

			//val f =  add(5) // does not compile, expecting 2nd param passed
			val f = add2(5)_ // can treat it as 'partially applied function' because 2nd parameter is defined,
			// so we may mark it to be omitted  (#partially-applied-function related)
			println("2.2.0: " + f)
			println("2.2.1: " + f(6))
			println("2.2.2: " + f(7))

		}

		println

		{
			/**
			 * Define a function as f(p1:T) = (p2:T) => p1 + p2
			 */
			def t1 {
				println("==>t1")
				def first(x: Int) = (y: Int) => x + y
				val second = first(123)
				println("second(4) = " + second(4))
				println("second(-122) = " + second(-122))
				println(s"second(-2) = ${second(-2)}")
				println("<==t1")
			}

			/**
			 * Define a function as f(p1:T)(p2:T) = p1 + p2
			 */
			def t2 {
				println("==>t2")
				def first(x: Int)(y: Int) = x + y
				val second = first(123) _
				println("second(4) = " + second(4))
				println("second(-122) = " + second(-122))
				println(s"second(-2) = ${second(-2)}")
				println("<==t2")
			}
			
			t1
			t2
		}
	}
	println("<==CurryTest")
}