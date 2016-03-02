/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.plist

import scala.collection.mutable.ListBuffer

/**
 * Playing with List: ListBuffer.
 *
 * @author Yuriy Stul
 *
 */
object PlayingWithList {
	def main(args: Array[String]) {
		println("==>main")
		val b1 = new ListBuffer[Int]()
		b1.+=(1)
		println(b1)
		b1 += 2
		println(b1)
		println(b1(0))
		println(b1(1))
		println

		b1.foreach { x => println(x) }
		println

		for (i <- 0 to 1) {
			println(s"i=$i, b1($i)=${b1(i)}")
		}
		println

		for (i <- 0.to(1)) {
			println(s"i=$i, b1($i)=${b1(i)}")
		}
		println

		for (i <- Range(0, 1)) {
			println(s"i=$i, b1($i)=${b1(i)}")
		}

		println(s"b1.size=${b1.size}")

		b1(0) = 100
		println(b1)

		val digits = List(4, 2)
		println(s"digits=$digits")
		println(s"digits.head=${digits.head}")
		println(s"digits.tail=${digits.tail}")
		println(s"digits.tail.tail=${digits.tail.tail}")
		
		val digits2 = 9 :: digits
		println(s"digits2=$digits2")
		
		println(s"digits ++ digits2=${digits ++ digits2}")
		println(s"digits +: (digits2)=${digits +: (digits2)}")
		println(s"digits :+ (digits2)=${digits :+ (digits2)}")
		println(s"digits ::: (digits2)=${digits ::: (digits2)}")
		println("<==main")
	}
}