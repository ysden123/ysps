/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.operators

/**
 * Playing with 'apply' and 'unapply'
 *
 * @author Yuriy Stul
 *
 */
object ApplyUnapply {
	class Fraction(val n: Int, val d: Int) {
		override def toString = s"n=$n, d=$d"
	}

	class FractionNoApply(n: Int, d: Int) {
		override def toString = s"n=$n, d=$d"
	}

	object Fraction {
		/**
		 * Apply
		 *
		 * @param n the n
		 * @param d the d
		 * @return Fraction(n,d)
		 */
		def apply(n: Int, d: Int) = new Fraction(n, d)

		/**
		 * Unapply - extractor
		 *
		 * @param input the Fraction(n,d)
		 * @return Some(n,d)
		 */
		def unapply(input: Fraction) = if (input.n == 0) None else Some((input.n, input.d))
	}

	/**
	 * Case classes automatically have 'apply' and 'unapply' methods.
	 * @author Yuriy Stul
	 *
	 */
	case class Currency(v: Double, unit: String) {
		override def toString = s"v=$v, unit=$unit"
	}

	def main(args: Array[String]): Unit = {
		println("==>main")

		// Class without apply
		val fn1 = new FractionNoApply(0, 7)
		println(s"fn1=$fn1")

		// Using 'apply'
		// Create new instance without 'new' key word
		val f1 = Fraction(1, 2)
		println(s"f1=$f1")

		// Using 'unapply'
		val f1e = Fraction.unapply(f1)
		println(s"f1e=$f1e")

		val f2 = Fraction.apply(3, 4)
		println(s"f2=$f2")

		// Using case class
		val c1 = Currency(12.9, "ILS")
		println(s"c1=$c1")
		c1 match {
			case Currency(amount, "ILS") => println(s"$amount NIS")
		}
		println("<==main")
	}
}