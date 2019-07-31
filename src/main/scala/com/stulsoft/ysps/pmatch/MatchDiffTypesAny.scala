/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.pmatch

/** Pattern matching with Any
  *
  * @author Yuriy Stul
  */
object MatchDiffTypesAny extends App {
  type Receive = PartialFunction[Any, Unit]

  def receive1: Receive = {
    case Msg1(name) =>
      println(s"Received Msg1 with name: $name")
    case Msg2 =>
      println(s"Received Msg2")
    case Msg3 =>
      println(s"Received Msg3")
    case x =>
      println(s"receive1: Unknown message $x")
  }

  def receive2: Receive = {
    case x: Msg1 =>
      println(s"Received Msg1 with name: ${x.name}")
    // Compilation error:
    //    case _: Msg2 =>
    //      println(s"Received Msg2")
    // Runtime error:
    case _: Msg3 =>
      println(s"Received Msg3")
    case x =>
      println(s"receive2: Unknown message $x")
  }

  receive1(Msg1("test1"))
  receive2(Msg1("test1"))
  receive1(Msg2)

  receive1(Msg3)
  receive2(Msg3)
}
