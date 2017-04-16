package com.stulsoft.ysps.ptypes

object Tuples {
	println("Tuples")                         //> Tuples

	// Define a tuple
	val t1 = (1, false, "Scala")              //> t1  : (Int, Boolean, String) = (1,false,Scala)

	// Access to tuple's elements
	t1._1                                     //> res0: Int = 1
	t1._2                                     //> res1: Boolean = false
	t1._3                                     //> res2: String = Scala
	
	// Define tuple
	val t2 = "title" -> "Begining Scala"      //> t2  : (String, String) = (title,Begining Scala)
	
	// Define a tuple with tuple inside
	val t3 = 1 -> "more" -> true              //> t3  : ((Int, String), Boolean) = ((1,more),true)
	t3._1                                     //> res3: (Int, String) = (1,more)
	t3._2                                     //> res4: Boolean = true
	t3._1._2                                  //> res5: String = more
}