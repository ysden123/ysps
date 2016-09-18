package com.stulsoft.ysps.pmaybe

/**
  * Created by Yuriy Stul on 9/18/2016.
  *
  * @see http://groz.github.io/scala/intro/monads/
  */
object MaybeWithMapAndFlatMap {

  abstract class Maybe[+T] {
    def map[U](f: T => U): Maybe[U]

    def flatMap[U](f: T => Maybe[U]): Maybe[U]
  }

  case class Just[T](get: T) extends Maybe[T] {
    def map[U](f: T => U) = Just(f(get))

    def flatMap[U](f: T => Maybe[U]): Maybe[U] = f(get)
  }

  case object Not extends Maybe[Nothing] {
    def map[U](f: Nothing => U) = Not

    // Always Not
    def flatMap[U](f: Nothing => Maybe[U]): Maybe[U] = Not
  }

  case class Person(
                     name: String,
                     nickname: Maybe[String],
                     height: Maybe[Double],
                     weight: Maybe[Double])

  def isTall(p: Person): Maybe[Boolean] = p.height.map(_ > 1.9)

  def nicknameLength(p: Person): Maybe[Int] = p.nickname.map {
    _.length
  }

  def calcBMI(p: Person): Maybe[Double] =
    p.weight.flatMap { w =>
      p.height.map { h => w / (h * h) }
    }

  def main(args: Array[String]): Unit = {
    println("==>main")
    test1()
    test2()
    test3()
    test4()
    println("<==main")
  }

  def test1(): Unit = {
    println("==>test1")
    val p = new Person("Yurik", Just("den"), Just(1.75), Just(75.0))
    println(s"isTall(p) = ${isTall(p)}")
    println(s"nicknameLength(p) = ${nicknameLength(p)}")
    println(s"calcBMI(p) = ${calcBMI(p)}")
    println("<==test1")
  }

  def test2(): Unit = {
    println("==>test2")
    val p = new Person("Yurik", Just("den"), Just(2.1), Just(75.0))
    println(s"isTall(p) = ${isTall(p)}")
    println(s"nicknameLength(p) = ${nicknameLength(p)}")
    println(s"calcBMI(p) = ${calcBMI(p)}")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    val p = new Person("Yurik", Just("den"), Not, Just(75.0))
    println(s"isTall(p) = ${isTall(p)}")
    println(s"nicknameLength(p) = ${nicknameLength(p)}")
    println(s"calcBMI(p) = ${calcBMI(p)}")
    println("<==test3")
  }

  def test4(): Unit = {
    println("==>test4")
    val p = new Person("Yurik", Not, Not, Not)
    println(s"isTall(p) = ${isTall(p)}")
    println(s"nicknameLength(p) = ${nicknameLength(p)}")
    println(s"calcBMI(p) = ${calcBMI(p)}")
    println("<==test4")
  }
}
