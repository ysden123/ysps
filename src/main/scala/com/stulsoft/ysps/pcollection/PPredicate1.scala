package com.stulsoft.ysps.pcollection

import java.util
import java.util.function.Predicate
import java.util.stream.Collectors

/**
  * @author Yuriy Stul
  * @since 4/22/2018
  */
object PPredicate1 extends App {
  test1()

  def test1(): Unit = {
    println("==>test1")
    val result1 = f1(util.Arrays.asList("abc444", "aba444", "bca444", "ca444"))
    result1.stream().forEach(i => println(i))

    val result2 = f2(util.Arrays.asList("aba444", "bca444", "ca444", "abc444"))
    result2.stream().forEach(i => println(i))
    println("<==test1")
  }

  def f1(srcList: util.List[String]): util.List[String] = {
    val listToCompare:Set[String] = Set("abc444","cba")
    srcList.stream().filter((t: String) => listToCompare.contains(t)).collect(Collectors.toList[String])
  }

  def f2(srcList: util.List[String]): util.List[String] = {

    val listToCompare:Set[String] = Set("abc444","cba")
    val predicate = new Predicate[String] {
      override def test(t: String): Boolean = listToCompare.contains(t)
    }
    srcList.stream().filter(predicate).collect(Collectors.toList[String])
  }
}
