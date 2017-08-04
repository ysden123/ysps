/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pvariance


/**
  * @author Yuriy Stul
  */

object Office123 extends App {

  test1()
  testInvariant()
  testCovariant1()
  testCovariant2()
  testCovariant3()
  testCovariant4()

  def test1(): Unit = {
    println("==>test1")
    val young1 = new YoungWorker("young 1")
    val young2 = new YoungWorker("young 2")

    val middle1 = new MiddleWorker("middle 1")
    val middle2 = new MiddleWorker("middle 2")

    val senior = new SeniorWorker("senior")

    val workers = Seq(young1, young2, middle1, middle2, senior)
    for (worker <- workers) println(s"${worker.name} says ${worker.order} ")
    println("<==test1")
  }

  def testInvariant(): Unit = {
    println("==>testInvariant")
    val workers = Seq(
      new OfficeWorkerInvariant[YoungWorker](new YoungWorker("young i1")),
      new OfficeWorkerInvariant[MiddleWorker](new MiddleWorker("middle i1")),
      new OfficeWorkerInvariant[SeniorWorker](new SeniorWorker("senior i1"))
    )
    for (worker <- workers) worker.doWork()
    println("<==testInvariant")
  }

  def testCovariant1(): Unit = {
    println("==>testCovariant1")
    val workers = Seq(
      new OfficeWorkerCovariant1[YoungWorker](new YoungWorker("young c1")),
      new OfficeWorkerCovariant1[MiddleWorker](new MiddleWorker("middle c1")),
      new OfficeWorkerCovariant1[SeniorWorker](new SeniorWorker("senior c1"))
    )
    for (worker <- workers) worker.doWork()
    println("<==testCovariant1")
  }

  def testCovariant2(): Unit = {
    println("==>testCovariant2")
    val workers = Seq(
      new OfficeWorkerCovariant2[YoungWorker](new YoungWorker("young c2")),
      new OfficeWorkerCovariant2[MiddleWorker](new MiddleWorker("middle c2")),
      new OfficeWorkerCovariant2[SeniorWorker](new SeniorWorker("senior c2"))
    )
    for (worker <- workers) worker.doWork()
    println("<==testCovariant2")
  }

  def testCovariant3(): Unit = {
    println("==>testCovariant3")
    val workers = Seq(
      // Error     new OfficeWorkerCovariant3[YoungWorker](new YoungWorker("young c3")),
      new OfficeWorkerCovariant3[MiddleWorker](new MiddleWorker("middle c3")),
      new OfficeWorkerCovariant3[SeniorWorker](new SeniorWorker("senior c3"))
    )
    for (worker <- workers) worker.doWork()
    println("<==testCovariant3")
  }

  def testCovariant4(): Unit = {
    println("==>testCovariant4")
    val workers = Seq(
      // Error     new OfficeWorkerCovariant4[YoungWorker](new YoungWorker("young c4")),
      new OfficeWorkerCovariant4[MiddleWorker](new MiddleWorker("middle c4")),
      new OfficeWorkerCovariant4[SeniorWorker](new SeniorWorker("senior c4"))
    )
    for (worker <- workers) worker.doWork()
    println("<==testCovariant4")
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

  class OfficeWorkerInvariant[T <: Worker](worker: T) {
    def doWork(): Unit = {
      println(s"${worker.name} says ${worker.order} ")
    }
  }

  class OfficeWorkerCovariant1[+T <: Worker](worker: T) {
    def doWork(): Unit = {
      println(s"${worker.name} says ${worker.order} ")
    }
  }

  class OfficeWorkerCovariant2[+T <: YoungWorker](worker: T) {
    def doWork(): Unit = {
      println(s"${worker.name} says ${worker.order} ")
    }
  }

  class OfficeWorkerCovariant3[+T <: MiddleWorker](worker: T) {
    def doWork(): Unit = {
      println(s"${worker.name} says ${worker.order} ")
    }
  }

  class OfficeWorkerCovariant4[T <: MiddleWorker](worker: T) {
    def doWork(): Unit = {
      println(s"${worker.name} says ${worker.order} ")
    }
  }

  class OfficeWorkerCovariant5[T <: MiddleWorker](worker: T) {
    def doWork(): Unit = {
      println(s"${worker.name} says ${worker.order} ")
    }
  }

}