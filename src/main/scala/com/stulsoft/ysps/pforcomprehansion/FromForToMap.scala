/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.pforcomprehansion

import scala.util.{Success, Try}

/**
  * @see [[https://wordpress.com/read/blogs/14365184/posts/892 Scala – conversion from for-comprehension to map, flatMap]]
  * @author Yuriy Stul.
  */
object FromForToMap extends App {
  testWithTry()
  testWithOption()
  testWithOption2()

  def testWithTry(): Unit = {
    testWithFor()
    testWithMap()

    def getProduct(id: String): Try[String] = {
      Success(id + "123")
    }

    def getPrice(product: String): Try[Double] = {
      Success(10.0 + product.length)
    }

    def calculateProductPrice(product: String, price: Double): Try[Double] = {
      Success(product.length * price)
    }

    def testWithFor(): Unit = {
      val result = for {
        product <- getProduct("test")
        price <- getPrice(product)
        calculatedPrice <- calculateProductPrice(product, price)
        if calculatedPrice > 10
      } yield (product, calculatedPrice)

      println(s"testWithFor: result is $result")
    }

    def testWithMap(): Unit = {
      val result = getProduct("test").flatMap { product =>
        getPrice(product).flatMap { price =>
          calculateProductPrice(product, price).filter(p => p > 10)
            .map { p => (product, p) }
        }
      }

      println(s"testWithMap: result is $result")
    }
  }

  def testWithOption(): Unit = {
    testWithFor()
    testWithMap()

    def getProduct(id: String): Option[String] = {
      Some(id + "123")
    }
    def getPrice(product: String): Option[Double] = {
      Some(10.0 + product.length)
    }

    def calculateProductPrice(product: String, price: Double): Option[Double] = {
      Some(product.length * price)
    }

    def testWithFor(): Unit = {
      val result = for {
        product <- getProduct("test")
        price <- getPrice(product)
        calculatedPrice <- calculateProductPrice(product, price)
        if calculatedPrice > 10
      } yield (product, calculatedPrice)

      println(s"testWithFor: result is $result")
    }

    def testWithMap(): Unit = {
      val result = getProduct("test").flatMap { product =>
        getPrice(product).flatMap { price =>
          calculateProductPrice(product, price).filter(p => p > 10)
            .map { p => (product, p) }
        }
      }

      println(s"testWithMap: result is $result")
    }
  }

  def testWithOption2(): Unit = {
    println("==>testWithOption2")
    testWithFor()
    testWithMap()

    def getProduct(id: String): Option[String] = {
      None
    }
    def getPrice(product: String): Option[Double] = {
      Some(10.0 + product.length)
    }

    def calculateProductPrice(product: String, price: Double): Option[Double] = {
      Some(product.length * price)
    }

    def testWithFor(): Unit = {
      val result = for {
        product <- getProduct("test")
        price <- getPrice(product)
        calculatedPrice <- calculateProductPrice(product, price)
        if calculatedPrice > 10
      } yield (product, calculatedPrice)

      println(s"testWithFor: result is $result")
    }

    def testWithMap(): Unit = {
      val result = getProduct("test").flatMap { product =>
        getPrice(product).flatMap { price =>
          calculateProductPrice(product, price).filter(p => p > 10)
            .map { p => (product, p) }
        }
      }

      println(s"testWithMap: result is $result")
    }
    println("<==testWithOption2")
  }
}
