/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pvariance

/** Playing with upper bound.
 *
 * An upper type bound T <: A declares that type variable T refers to a subtype of type A.
 *
 * @see [[http://docs.scala-lang.org/tutorials/tour/upper-type-bounds.html Upper Type Bounds]]
 * @author Yuriy Stul
 */
object OfficeUpperBound extends App {

  test1()

  def test1(): Unit = {
    println("==>test1")
    val workers = Seq(
      new OfficeWorker[YoungWorker](new YoungWorker("young1")),
      new OfficeWorker[MiddleWorker](new MiddleWorker("middle1")),
      new OfficeWorker[SeniorWorker](new SeniorWorker("middle1"))
    )
    for (worker <- workers) worker.doWork()

    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val workers = Seq(
      new OfficeWorker[YoungWorker](new YoungWorker("young21")),
      new OfficeWorker[YoungWorker](new MiddleWorker("middle21")),
      new OfficeWorker[YoungWorker](new SeniorWorker("senior21")),

      // Error new OfficeWorker[MiddleWorker](new YoungWorker("young22")),
      new OfficeWorker[MiddleWorker](new MiddleWorker("middle22")),
      new OfficeWorker[MiddleWorker](new SeniorWorker("senior22")),

      // Error  new OfficeWorker[SeniorWorker](new YoungWorker("young23")),
      // Error new OfficeWorker[SeniorWorker](new MiddleWorker("middle23")),
      new OfficeWorker[SeniorWorker](new SeniorWorker("middle2"))
    )
    for (worker <- workers) worker.doWork()

    println("<==test2")
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
   * Class with Low Bound
   *
   * @param worker a worker
   * @tparam T specifies the worker may any subclass of Worker
   */
  class OfficeWorker[T <: Worker](worker: T) {
    def doWork(): Unit = {
      println(s"${worker.name} says ${worker.order} ")
    }
  }

}
