package com.stulsoft.ysps.pakka.actors

import akka.actor.{Actor, ActorLogging}

/**
  * Created by Yuriy Stul on 10/1/2016.
  */


// Note: Usually the message object (GreeterMessages)
// and the actor class (GreeterActor) will be called the same thing (eg. Greeter)
object GreeterMessages {
  case object Greet
  case object Done
}


class GreeterActor extends Actor with ActorLogging {
  def receive = {
    case GreeterMessages.Greet =>
      val greetMsg = "Hello World!"
      println(s"===>GreeterActor.receive. greetMsg: $greetMsg")
      log.info(greetMsg)
      sender() ! GreeterMessages.Done // Send the 'Done' message back to the sender
  }
}