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
	 * First id is 0.
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
	 * Declaration of MyType2 enumeration.
	 *
	 * First id is 100
	 *
	 * @author Yuriy Stul
	 *
	 */
	object MyType2 extends Enumeration(100) {
		type MyType2 = Value
		val Type21, Type22, Type23 = Value
	}

	import MyType2._

	/**
	 * Declaration of Enumeration with a text values.
	 *
	 * @author Yuriy Stul
	 *
	 */
	object MyTypeWithStrValues extends Enumeration {
		type MyTypeWithStrValues = Value
		val One = Value("1")
		val Two = Value("2")
		val Less = Value("<")
	}

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
		println

		// Enumerate all values for MyType2
		MyType2.values.foreach { t => demoMyType2(t) }
		println
		
		// Enumeration with initial text values
		demoMyTypeWithStrValues
		println

	}

	/**
	 * Outputs details of Enumeration for MyType.
	 *
	 * @param t type to output details
	 */
	def demoMyType(t: MyType): Unit = {
		println(s"t: $t, t.id = ${t.id}")
	}

	/**
	 * Outputs details of Enumeration for MyType2.
	 *
	 * @param t type to output details
	 */
	def demoMyType2(t: MyType2): Unit = {
		println(s"t: $t, t.id = ${t.id}")
	}

	/**
	 * Demonstrates usage of Enumeration with text values.
	 */
	def demoMyTypeWithStrValues {
		println(s"Values of the MyTypeWithStrValues enumeration: ${MyTypeWithStrValues.values}")
		val one = MyTypeWithStrValues.One
		println(s"one = $one")
		val two = MyTypeWithStrValues.Two
		println(s"two = $two")
		val less = MyTypeWithStrValues.Less
		println(s"less = $less")
		val fromText = MyTypeWithStrValues.withName("2")
		println(s"fromtext = $fromText")
		MyTypeWithStrValues.values.foreach { x => println(s"x=$x, x.id=${x.id}") }
	}
}