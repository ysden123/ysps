package com.stulsoft.ysps.plist

object SortingLists {
	// [[http://techie-notebook.blogspot.co.il/2014/07/difference-between-sorted-sortwith-and.html]]
	println("Sorting lists in Scala.")        //> Sorting lists in Scala.

	// Sequence of numbers
	val xs = Seq(1, 5, 3, 4, 6, 2)            //> xs  : Seq[Int] = List(1, 5, 3, 4, 6, 2)

	// (I) Sort using Natural ordering as defined for Integers in Scala Library
	xs.sorted                                 //> res0: Seq[Int] = List(1, 2, 3, 4, 5, 6)

	// (II) Sort 'with' a comparator function
	xs.sortWith(_ < _)                        //> res1: Seq[Int] = List(1, 2, 3, 4, 5, 6)
	xs.sortWith(_ > _)                        //> res2: Seq[Int] = List(6, 5, 4, 3, 2, 1)
	xs.sortWith((left, right) => left > right)//> res3: Seq[Int] = List(6, 5, 4, 3, 2, 1)

	// Create a Person class
	case class Person(val name: String, val age: Int)

	// Define a list of Persons
	val ps = Seq(Person("John", 32), Person("Bruce", 24), Person("Cindy", 33), Person("Sandra", 18))
                                                  //> ps  : Seq[com.stulsoft.ysps.plist.SortingLists.Person] = List(Person(John,32
                                                  //| ), Person(Bruce,24), Person(Cindy,33), Person(Sandra,18))

	// Sort People by increasing Age (natural ordering of Int will kick in)
	ps.sortBy(_.age)                          //> res4: Seq[com.stulsoft.ysps.plist.SortingLists.Person] = List(Person(Sandra,
                                                  //| 18), Person(Bruce,24), Person(John,32), Person(Cindy,33))

	// Sort People by decreasing Age, using a comparator function
	ps.sortWith(_.age > _.age)                //> res5: Seq[com.stulsoft.ysps.plist.SortingLists.Person] = List(Person(Cindy,3
                                                  //| 3), Person(John,32), Person(Bruce,24), Person(Sandra,18))
}