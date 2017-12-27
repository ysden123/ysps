package com.stulsoft.ysps.util

import java.util.concurrent.TimeUnit

/**
  * @author Yuriy Stul.
  */
object BenchmarkMaster {
  private val ASCENDING = true
  private val DESCENDING = false

  /** Executes collection of functions and returns collection of benchmark results
    *
    * @param samples specifies collection of a functions to execute; the function returns {{{Tuple2[String,Any]}}}
    *                where _1 is text description and _2 is a result
    * @param repeat  specifies how times to execute a sample; default value is 1
    * @return collection of benchmarks
    */
  def execute(samples: Seq[() => (String, Any)], repeat: Int = 1): Seq[BenchmarkResult[Any]] = {
    require(samples != null, "samples could not be null")
    samples.map(sample => {
      var totalDuration = 0L
      var text = ""
      var value: Any = null
      (1 to repeat).foreach(i => {
        val start = System.nanoTime()
        val result = sample()
        val end = System.nanoTime()

        totalDuration += TimeUnit.NANOSECONDS.toMillis(end - start)
        if (i == 1) {
          text = result._1
          value = result._2
        }
      })
      BenchmarkResult(totalDuration / repeat, text, value)
    })
  }

  def sortBenchmarkResultsByDurationAscending(results: Seq[BenchmarkResult[Any]]): Seq[BenchmarkResult[Any]] =
    sortBenchmarkResults(results, ASCENDING)

  def sortBenchmarkResultsByDurationDescending(results: Seq[BenchmarkResult[Any]]): Seq[BenchmarkResult[Any]] =
    sortBenchmarkResults(results, DESCENDING)

  private def sortBenchmarkResults(results: Seq[BenchmarkResult[Any]], isAscending: Boolean): Seq[BenchmarkResult[Any]] = {
    if (isAscending)
      results.sortBy(r => r.duration)
    else
      results.sortBy(r => -r.duration)
  }
}
