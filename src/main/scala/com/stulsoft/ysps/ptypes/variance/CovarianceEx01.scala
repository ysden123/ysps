/*
 * Copyright (c) 2019. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes.variance

import com.typesafe.scalalogging.LazyLogging

/*
Example of usage of covariance
See also  https://blog.knoldus.com/covariance-and-contravariance-in-scala/
*/

abstract class Vehicle

case class Car() extends Vehicle

case class IncorrectParking[A](vehicle: A)

case class Parking[+A](vehicle: A)

object CovarianceEx01 extends App with LazyLogging {

  val car = Car()
//   val incorrectParking: IncorrectParking[Vehicle] = IncorrectParking[Car](car) // Error: type mismatch; Car is not type of Vehicle

  val carParking: Parking[Vehicle] = Parking[Car](car)
  logger.info(carParking.toString) // ==> Parking(Car())

  val carParking2: Parking[Vehicle] = Parking(car) // ==> Parking(Car())
  logger.info(carParking2.toString) // ==> Parking(Car())
}