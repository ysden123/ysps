/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.parray

/**
  * @author Yuriy Stul
  */
object PMatrix extends App {
  println("==>main")
  val a1 = Array.ofDim[Int](3, 2)
  a1(0)(0) = 1
  a1(1)(0) = 2
  a1(2)(0) = 3

  a1(0)(1) = 10
  a1(1)(1) = 20
  a1(2)(1) = 30


  println(s" a1.indices: ${a1.indices}")
  a1.indices.foreach(i => {
    println(a1(i).mkString(","))
    //    a1(i).indices.foreach(j=>{
    //      println(a1(i)(j))
    //    })
  })

  val a2 = Array(Array(1.0, 2.0),
    Array(2.0, 3.0))
  println(a2.indices)
  println(a2(0).indices)

  a2.indices.foreach(i => {
    a2(i).indices.foreach(j => {
      a2(0).indices.foreach(r => {
        println(s"i = $i, j = $j, r = $r")
      })
    })
  })

  val a3 = Array(Array(1.0, 2.0),
    Array(2.0, 3.0),
    Array(20.0, 30.0))
  println(a3.indices)
  println(a3(0).indices)

  println("<==main")
}
