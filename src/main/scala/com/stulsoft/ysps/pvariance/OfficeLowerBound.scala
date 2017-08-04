/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pvariance

/** Playing with lower bound.
  *
  * The term B >: A expresses that the type parameter B or the abstract type B refer to a supertype of type A.
  * In most cases, A will be the type parameter of the class and B will be the type parameter of a method.
  *
  * Type hierarchy:
  * {{{
  *    Worker (Trait)
  *       ^
  *       |
  *    YoungWorker
  *       ^
  *       |
  *    MiddleWorker
  *       ^
  *       |
  *    SeniorWorker
  * }}}
  * @see [[http://docs.scala-lang.org/tutorials/tour/lower-type-bounds.html Lower Type Bounds]]
  * @author Yuriy Stul
  */
object OfficeLowerBound extends App {

  test1()
  test2()
  test3()

  def test1(): Unit = {
    println("==>test1")
    val worker = new YoungWorker("young")
    val boss = new MiddleWorker("middle")

    val team = new Team[MiddleWorker, YoungWorker](boss, Seq(worker))
    println(s"Boss ${team.boss.name} says: ${team.boss.order} ")
    println("Stuff answer:")
    team.staff.foreach(w => println(s"\tWorker ${w.name} says: ${w.order}"))

    // Wrong! Type mismatch
    //    val wrongTeam = new Team[YoungWorker,MiddleWorker](worker, Seq(boss))
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val worker = new YoungWorker("young")
    val boss = new MiddleWorker("middle")

    val team = new Team2[MiddleWorker, YoungWorker](boss, Seq(worker))
    println(s"Boss ${team.boss.name} says: ${team.boss.order} ")
    println("Stuff answer:")
    team.staff.foreach(w => println(s"\tWorker ${w.name} says: ${w.order}"))

    // Wrong! Type mismatch
    //    val wrongTeam = new Team[YoungWorker,MiddleWorker](worker, Seq(boss))
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    val worker = new YoungWorker("young")
    val boss = new SeniorWorker("senior")

    val team = Team3[MiddleWorker, YoungWorker](boss, Seq(worker))
    println(s"Boss ${team.boss.name} says: ${team.boss.order} ")
    println("Stuff answer:")
    team.staff.foreach(w => println(s"\tWorker ${w.name} says: ${w.order}"))

    println("<==test3")
  }

  trait Worker {
    def name: String

    def order: String
  }

  class YoungWorker(workerName: String) extends Worker {
    override def name: String = workerName

    override def order: String = "I did it!"
  }

  class MiddleWorker(workerName: String) extends YoungWorker(workerName) {
    override def order: String = "I'll try"
  }

  class SeniorWorker(workerName: String) extends MiddleWorker(workerName) {
    override def order: String = "Everything will be done"
  }

  /**
    * Team class with defined type of worker.
    *
    * @param boss  the boss
    * @param staff the collection of staff workers
    * @tparam W specifies subtype of Worker: YoungWorker, MiddleWorker, and SeniorWorker; upper bounding
    * @tparam S specifies supertype of W;lower bounding
    */
  class Team[W <: Worker, S >: W](val boss: W, val staff: Seq[S])

  /**
    * Team class without defined type of worker.
    *
    * @param boss  the boss
    * @param staff the collection of staff workers
    * @tparam B boss type
    * @tparam S staff type, should be super type of boss type; lower bounding
    */
  class Team2[B, S >: B](val boss: B, val staff: Seq[S])

  /**
    * Team case class without defined type of worker.
    *
    * @param boss  the boss
    * @param staff the collection of staff workers
    * @tparam B boss type
    * @tparam S staff type, should be super type of boss type; lower bounding
    */
  case class Team3[B, S >: B](boss: B, staff: Seq[S])
}
