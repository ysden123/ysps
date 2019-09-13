/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pmap.withflat

import scala.collection.immutable.ArraySeq
import scala.util.{Failure, Success, Try}

/** Playing with map, flatMap, ant Try
  *
  * @author Yuriy Stul
  */
object MapWithFlatMap1 extends App {

  test1()
  test2()
  test3()
  test4()

  def test1(): Unit = {
    println("==>test1")
    val a1 = generatePersons()
    println(s"a1: $a1")
    val l1 = a1.toList
    println(s"l1: $l1")
    val m1 = l1.map(i => i.map(p => p))
    println(s"m1: $m1")

    val l2 = a1.map(i => i.get)
    println(s"l2: $l2") // l2: ArraySeq(List(Person22(111), Person22(222)), List(Person22(33)), List(Person22(444), Person22(555)))
  }

  def test2(): Unit = {
    println("==>test2")
    val a1 = generatePersons2()
    println(s"a1: $a1")
    val l1 = a1.toList
    println(s"l1: $l1")
    val m1 = l1.map(i => i.map(p => p))
    println(s"m1: $m1")

    val l2 = a1.map {
      case Success(v) => v
      case _ => Nil
    }
    println(s"l2: $l2")

    val l3 = a1.flatMap {
      case Success(v) => v
      case _ => Nil
    }
    println(s"l3: $l3")

    val l4 = l3.toList
    println(s"l4: $l4") // 4: List(Person22(111), Person22(222), Person22(444), Person22(555))
  }

  def test3(): Unit = {
    println("==>test3")
    val a1 = generatePersons2()
    println(s"a1: $a1")

    val l1 = a1.flatMap(i => i.getOrElse(Nil)).toList
    println(s"l1: $l1") // l1: List(Person22(111), Person22(222), Person22(444), Person22(555))
  }
  
  def test4(): Unit = {
    println("==>test4")
    val a1 = generatePersons2()
    println(s"a1: $a1")

    val l1 = a1.map(i => i.getOrElse(Nil)).toList
    println(s"l1: $l1") // List(List(Person22(111), Person22(222)), List(), List(Person22(444), Person22(555)))
  }
  
  def generatePersons(): ArraySeq[Try[List[Person22]]] = {
    ArraySeq.from(List(
      Success(List(Person22("111"), Person22("222"))),
      Success(List(Person22("33"))),
      Success(List(Person22("444"), Person22("555"))))
    )
  }

  def generatePersons2(): ArraySeq[Try[List[Person22]]] = {
    ArraySeq.from(List(
      Success(List(Person22("111"), Person22("222"))),
      Failure(new RuntimeException("Test")),
      Success(List(Person22("444"), Person22("555"))))
    )
  }
}
