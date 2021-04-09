/**
 * Copyright (c) 2016, Yuriy Stul. All rights reserved
 */

package com.stulsoft.ysps.ptypes

/* ******************************************************
 * Demonstrates usage of companion in Scala.
 * 
 * Factories.
 * *****************************************************/

/**
 * Companion class.
 *
 * Declares a shape with one abstract value member 'area'
 *
 * @author Yuriy Stul
 *
 */
trait Shape {
  def area: Double
}

/**
 * Specifies the companion object.
 *
 * @author Yuriy Stul
 *
 */
object Shape {

  /**
   * Factory method for circle (one parameter).
   *
   * @param radius specifies circle radius.
   * @return instance of the Circle class.
   */
  def apply(radius: Double): Shape = new Circle(radius)

  /**
   * Factory method for rectangle (two parameters).
   *
   * @param width  specifies rectangle width
   * @param height specifies rectangle height
   * @return instance of the Rectangle class.
   */
  def apply(width: Double, height: Double): Shape = new Rectangle(width, height)

  /**
   * Implements Shape for circle.
   *
   * @author Yuriy Stul
   *
   */
  private class Circle(radius: Double) extends Shape {
    override val area = 3.14 * radius * radius
  }

  /**
   * Implements Shape for rectangle.
   *
   * @author Yuriy Stul
   *
   */
  private class Rectangle(width: Double, height: Double) extends Shape {
    override val area = width * height
  }
}

/**
 * Test application for shapes.
 *
 * @author Yuriy Stul
 *
 */
object CampanionTest extends App {

  // Create instances of circles.
  val circle1 = Shape(3)
  val circle2 = Shape.apply(4)
  // Create instances of rectangles.
  val rectangle1 = Shape(2, 4)
  val rectangle2 = Shape.apply(5, 6)

  /**
   * Debug output.
   *
   * @param name  shape name
   * @param shape a shape
   */
  def debug(name: String, shape: Shape): Unit = {
    println(s"$name: $shape, area=${shape.area}")
  }

  debug("circle1", circle1)
  debug("rectangle1", rectangle1)

  debug("circle2", circle2)
  debug("rectangle2", rectangle2)
}