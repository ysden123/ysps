package com.stulsoft.ysps.pakka.actors

import akka.actor.{Actor, Props}

/**
  * Created by Yuriy Stul on 10/1/2016.
  */
class HelloWorldActor extends Actor {
  override def preStart(): Unit = {
    // create the greeter actor
    val greeter = context.actorOf(Props[GreeterActor], "greeter")

    // Send it the 'Greet' message
    greeter ! GreeterMessages.Greet
  }

  override def receive: Receive = {
    // When we receive the 'Done' message, stop this actor
    // (which if this is still the initialActor will trigger the deathwatch and stop the entire ActorSystem)
    case GreeterMessages.Done => {
      context.stop(self)
    }
  }
}
