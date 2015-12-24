/**
 * Copyright (c) 2015, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.penum

/**
 * Playing with Scala - conversions with Enumeration
 * 
 * @author Yuriy Stul
 *
 */
object EnumConversions {

	/**
	 * Declaration of MyType enumeration.
	 *
	 * @author Yuriy Stul
	 *
	 */
	object MyType extends Enumeration {
		type MyType = Value
		val Type1, Type2, Type3 = Value
	}

	import MyType._

	/**
	 * Main method for testing.
	 *
	 * @param args no argument is required.
	 */
	def main(args: Array[String]): Unit = {
		// Initialization of MyType
		val t1: MyType = MyType.Type1
		println(s"t1 is $t1")
		demoMyType(t1)
		println

		// Enumerate all values
		MyType.values.foreach { t => demoMyType(t) }
		println

		// Convert Int to Enumeration
		val t2 = MyType(2)
		demoMyType(t2)
		println

		try {
			val t2e = MyType(123)
		} catch {
			case e: NoSuchElementException => println(s"MyType element with id 123 doesn't exist! Error: ${e.getMessage}")
		}

		// Convert text to Enumeration
		val t3 = MyType.withName("Type2")
		demoMyType(t3)
		println

		try {
			val t3e = MyType.withName("Type2ERROR")
		} catch {
			case e: NoSuchElementException => println(s"MyType element with name Type2ERROR doesn't exist! Error: ${e.getMessage}")
		}
	}

	/**
	 * Outputs details of Enumeration.
	 *
	 * @param t type to output details
	 */
	def demoMyType(t: MyType): Unit = {
		println(s"t: $t, t.id = ${t.id}")
	}

}