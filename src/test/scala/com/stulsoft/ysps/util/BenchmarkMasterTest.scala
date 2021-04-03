package com.stulsoft.ysps.util

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

/**
  * @author Yuriy Stul.
  */
class BenchmarkMasterTest extends AnyFlatSpec with Matchers{

  val test1: () => (String, Int) = () => {
    try {
      Thread.sleep(100)
    }
    catch {
      case _: Exception =>
    }
    ("test 1", 123)
  }

  val test2: () => (String, Int) = () =>  {
    try {
      Thread.sleep(110)
    }
    catch {
      case _: Exception =>
    }
    ("test 2", 1230)
  }

  val test3: () => (String, Int) = () => {
    try {
      Thread.sleep(120)
    }
    catch {
      case _: Exception =>
    }
    ("test 3", 12300)
  }

  behavior of "BenchmarkMasterTest"

  "execute" should "return collection of benchmarks" in {
    val results = BenchmarkMaster.execute(Seq(test1, test2, test3))
    results.length shouldBe 3
//    results.foreach(println)
  }

  it should "work with repeat > 1" in {
    val results = BenchmarkMaster.execute(Seq(test1, test2, test3), 10)
    results.length shouldBe 3
//    results.foreach(println)
  }

  "sortBenchmarkResultsByDurationAscending" should "sort ascending" in {
    val results = BenchmarkMaster.sortBenchmarkResultsByDurationAscending(BenchmarkMaster.execute(Seq(test1, test2, test3)))
    results.length shouldBe 3
//    results.foreach(println)
    results.head.text shouldBe "test 1"
  }

  "sortBenchmarkResultsByDurationDescending" should "sort descending" in {
    val results = BenchmarkMaster.sortBenchmarkResultsByDurationDescending(BenchmarkMaster.execute(Seq(test1, test2, test3)))
    results.length shouldBe 3
//    results.foreach(println)
    results.head.text shouldBe "test 3"
  }

}
