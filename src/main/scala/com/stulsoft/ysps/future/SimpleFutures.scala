/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.future

import scala.concurrent.{ Future, Await }
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Demonstrates simple usage of Future.
 *
 * @author Yuriy Stul
 *
 */
object SimpleFutures {

	/**
	 * Main for test.
	 *
	 * @param args
	 */
	def main(args: Array[String]): Unit = {
		println("==>main")

		t01
		t02

		println("<==main")
	}

	def t01: Unit = {
		println("==>t01")
		/**
		 * Definition of future to calculate sum of sequence from 1 to 100000
		 * @return
		 */
		def sumF = Future {
			println("We are inside sumF")
			(1L to 100000L).sum
		}

		/**
		 * Handler for success
		 */
		sumF onSuccess {
			case s => println(s"sumF was calculated: s = $s")
		}

		/**
		 * Define multiplier on 2
		 */
		val doubleSumF = sumF.flatMap {
			case s => Future { s * 2 }
		}

		/**
		 * Define multiplier on 3
		 */
		val trippleSumF = sumF.flatMap {
			case s => Future { s * 3 }
		}

		/**
		 * Define end formula
		 */
		val resultF = for {
			s1 <- doubleSumF
			s2 <- trippleSumF
		} yield s1 + s2
		
		val result = Await.result(resultF, 2.seconds)
		println(s"result (s * 2 + s *3) = $result")
		println("<==t01")
	}

	def t02: Unit = {
		println("==>t02")
		/**
		 * Definition of future to calculate sum of sequence from 1 to 100000
		 * @return
		 */
		def sumF = Future {
			println("We are inside sumF")
			(1L to 100000L).sum
		}
		
		/**
		 * Handler for success
		 */
		sumF onSuccess {
			case s => println(s"sumF was calculated: s = $s")
		}
		
		val result = Await.result(sumF, 2.seconds)
		println(s"result (s) = $result")
		println("<==t02")
	}
}