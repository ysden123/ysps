/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes.variance

import com.typesafe.scalalogging.LazyLogging

/*
Example of usage of contravariance
See also  https://blog.knoldus.com/covariance-and-contravariance-in-scala/
*/

abstract class Vehicle2

case class Car2() extends Vehicle2

case class IncorrectParking2[A](vehicle: A)

case class Parking2[-A]()

object ContravarianceEx01 extends App with LazyLogging {
//  val incorrectParking: Parking2[Car] = Parking2[String]  // ERROR: type mismatch; String is not supertype of Car

//  val incorrectParking: IncorrectParking2[Car] = IncorrectParking2[Vehicle] // ERROR: type mismatch; Vehicle is not type of Car

  val parking: Parking2[Car] = Parking2[Vehicle]
  logger.info(parking.toString) // ==> Parking2()
}