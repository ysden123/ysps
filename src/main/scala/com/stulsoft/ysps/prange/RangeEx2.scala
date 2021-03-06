package com.stulsoft.ysps.prange

import com.stulsoft.ysps.util.BenchmarkMaster
import scala.collection.parallel.CollectionConverters._

/** Playing with reduce in parallel
 *
 * @author Yuriy Stul.
 */
object RangeEx2 extends App {
  private val N = 100000

  val test1: () => (String, Int) = () => {
    val result = (1 to N).reduce((v1, v2) => v1 - v2)
    ("Without parallel", result)
  }

  val test2: () => (String, Int) = () => {
    val result = (1 to N).par.reduce((v1, v2) => v1 - v2)
    ("With parallel", result)
  }

  val test3: () => (String, Int) = () => {
    val result = -(1 to N).reduce((v1, v2) => v1 + v2)
    ("Without parallel plus and minus", result)
  }

  val test4: () => (String, Int) = () => {
    val result = -(1 to N).par.reduce((v1, v2) => v1 + v2)
    ("With parallel plus and minus", result)
  }

  val test5: () => (String, Int) = () => {
    val result = -(1 to N).sum
    ("Without parallel with sum instead reduce", result)
  }

  val test6: () => (String, Int) = () => {
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
        test6
      ),
      10))

  results.foreach(println)
}
