/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pvariance

/** Playing with upper bound.
  *
  * The term B >: A expresses that the type parameter B or the abstract type B refer to a supertype of type A.
  * In most cases, A will be the type parameter of the class and B will be the type parameter of a method.
  *
  * @see [[http://docs.scala-lang.org/tutorials/tour/lower-type-bounds.html Lower Type Bounds]]
  * @author Yuriy Stul
  */
object OfficeLowerBound extends App {

  def test1(): Unit = {
    val worker = new YoungWorker("young")
    val boss = new MiddleWorker("middle")

    //    val team = new Team[YoungWorker, MiddleWorker](boss, worker)
    val team = new Team[MiddleWorker](boss)
    team.worker =  team.setWorker(worker)
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

  class Team[+T](val boss: T) {
    var worker: Worker = _
    def setWorker[B >: T](theWorker: B): B = theWorker

    def doWork(): Unit = {
            println(s"Boss ${boss.name} says ${boss.order}")
            println(s"Worker ${worker.name} says ${worker.order}")
    }
  }

}
