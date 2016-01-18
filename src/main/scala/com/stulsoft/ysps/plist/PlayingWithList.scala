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
	}
}