package com.stulsoft.ysps.pmaybe

/**
  * Created by Yuriy Stul on 9/18/2016.
  *
  * @see http://groz.github.io/scala/intro/monads/
  */
object SimpleMaybe {

  abstract class Maybe[+T]

  case class Just[T](get: T) extends Maybe[T]

  case object Not extends Maybe[Nothing]

  case class Person(
                     name: String,
                     nickname: Maybe[String],
                     height: Maybe[Double],
                     weight: Maybe[Double])

  def isTall(p: Person): Maybe[Boolean] = p.height match {
    case Just(h) => Just(h > 1.9)
    case Not => Not
  }

  def nicknameLength(p: Person): Maybe[Int] = p.nickname match {
    case Just(nickname) => Just(nickname.length)
    case Not => Not
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
    println("<==test1")
  }
  def test2(): Unit = {
    println("==>test2")
    val p = new Person("Yurik", Just("den"), Just(2.1), Just(75.0))
    println(s"isTall(p) = ${isTall(p)}")
    println(s"nicknameLength(p) = ${nicknameLength(p)}")
    println("<==test2")
  }

  def test3(): Unit = {
    println("==>test3")
    val p = new Person("Yurik", Just("den"), Not, Just(75.0))
    println(s"isTall(p) = ${isTall(p)}")
    println(s"nicknameLength(p) = ${nicknameLength(p)}")
    println("<==test3")
  }

  def test4(): Unit = {
    println("==>test4")
    val p = new Person("Yurik", Not, Not, Just(75.0))
    println(s"isTall(p) = ${isTall(p)}")
    println(s"nicknameLength(p) = ${nicknameLength(p)}")
    println("<==test4")
  }
}
