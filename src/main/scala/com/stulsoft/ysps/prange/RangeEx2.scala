package com.stulsoft.ysps.prange

import com.stulsoft.ysps.util.BenchmarkMaster

/** Playing with reduce in parallel
  *
  * @author Yuriy Stul.
  */
object RangeEx2 extends App {
  private val N = 100000

  def test1(): (String, Int) = {
    val result = (1 to N).reduce((v1, v2) => v1 - v2)
    ("Without parallel", result)
  }

  def test2(): (String, Int) = {
    val result = (1 to N).par.reduce((v1, v2) => v1 - v2)
    ("With parallel", result)
  }

  def test3(): (String, Int) = {
    val result = -(1 to N).reduce((v1, v2) => v1 + v2)
    ("Without parallel plus and minus", result)
  }

  def test4(): (String, Int) = {
    val result = -(1 to N).par.reduce((v1, v2) => v1 + v2)
    ("With parallel plus and minus", result)
  }

  def test5(): (String, Int) = {
    val result = -(1 to N).sum
    ("Without parallel with sum instead reduce", result)
  }

  def test6(): (String, Int) = {
    val result = -(1 to N).par.sum
    ("With parallel with sum instead reduce", result)
  }

  val results = BenchmarkMaster
    .sortBenchmarkResultsByDurationAscending(BenchmarkMaster.execute(
      Seq(test1,
        test2,
        test3,
        test4,
        test5,
        test6,
      ),
      10))

  results.foreach(println)
}
