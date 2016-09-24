package com.stulsoft.ysps.preduce

/**
  * Playing with reduce, reduceLeft, and reduceRight.
  *
  * If reducing function is associative conversion, then no difference between reduce, reduceLeft,
  * and reduceRight.
  *
  * Result may be different, if reducing function is not associative.
  *
  * Created by Yuriy Stul on 9/24/2016.
  */
object PReduce {
  def main(args: Array[String]): Unit = {
    println("==>main")
    reduce()
    reduceLeft1()
    reduceLeft2()
    reduceRight1()
    reduceRight2()
    println("<==main")
  }

  def generatePersons(): List[Person] = {
    List(Person(10, 120, "person 1"), Person(11, 130, "person 2"), Person(12, 130, "person 3"))
  }

  /**
    * Associative reducing. Sums up all data members of the Person class.
    *
    * @param p1 first Person instance
    * @param p2 second Person instance
    * @return new Person(ag1 + ag2, height1 + height2, name1 + name2)
    */
  def reduceFunction1(p1: Person, p2: Person): Person = {
    new Person(p1.age + p2.age, p1.height + p2.height, p1.name + "|" + p2.name)
  }

  /**
    * Non-associative reducing. Subtracts data members of 2nd instance from data members of 1st instance (except names)
    *
    * @param p1 first Person instance
    * @param p2 second Person instance
    * @return new Person(ag1 - ag2, height1 - height2, name1 + name2)
    */
  def reduceFunction2(p1: Person, p2: Person): Person = {
    new Person(p1.age - p2.age, p1.height - p2.height, p1.name + "|" + p2.name)
  }

  def reduce(): Unit = {
    println("==>reduce")
    val l1 = generatePersons()
    val r1 = l1.reduce((p1, p2) => reduceFunction1(p1, p2))
    println(s"r1=$r1")
    println("<==reduce")
  }

  def reduceLeft1(): Unit = {
    println("==>reduceLeft1")
    val l1 = generatePersons()
    val r1 = l1.reduceLeft((p1, p2) => reduceFunction1(p1, p2))
    println(s"r1=$r1")
    println("<==reduceLeft1")
  }

  def reduceLeft2(): Unit = {
    println("==>reduceLeft2")
    val l1 = generatePersons()
    val r1 = l1.reduceLeft((p1, p2) => reduceFunction2(p1, p2))
    println(s"r1=$r1")
    println("<==reduceLeft2")
  }

  def reduceRight1(): Unit = {
    println("==>reduceRight1")
    val l1 = generatePersons()
    val r1 = l1.reduceRight((p1, p2) => reduceFunction1(p1, p2))
    println(s"r1=$r1")
    println("<==reduceRight1")
  }

  def reduceRight2(): Unit = {
    println("==>reduceRight2")
    val l1 = generatePersons()
    val r1 = l1.reduceRight((p1, p2) => reduceFunction2(p1, p2))
    println(s"r1=$r1")
    println("<==reduceRight2")
  }
}
