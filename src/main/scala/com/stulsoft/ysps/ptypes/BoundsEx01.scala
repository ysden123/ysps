/*
 * Copyright (c) 2017. Yuriy Stul
 */

package com.stulsoft.ysps.ptypes

/**
  * Playing with types
  *
  * @see [[https://twitter.github.io/scala_school/type-basics.html Type & polymorphism basics]]
  * @author Yuriy Stul
  */
object BoundsEx01 extends App {
  // Error: value sound is not a member of type parameter T
  //  def cacophony[T](things: Seq[T]) = things map (_.sound)

  /**
    * A function
    *
    * @param things collection of Animal objects
    * @tparam T specifies that only Animal and its subclasses (derived classes or child classes) may be used
    * @return the collection
    */
  private def bioPhony[T <: Animal](things: Seq[T]) = things map (_.sound)

  class Node1[T](x: T) {
    def sub(v: T): Node1[T] = new Node1(v)
  }

  // Error: covariant type T occurs in contravariant position in type T of value v
  //  class Node2[+T](x: T) {
  //    def sub(v: T): Node[T] = new Node(v)
  //  }

  class Node3[Bird](x: Bird) {
    def sub(v: Bird): Node3[Bird] = new Node3(v)
  }

  class Node4[Animal](x: Animal) {
    def sub(v: Animal): Node4[Animal] = new Node4(v)
  }

  /*
  The Node3 class is not subclass of Node4 class!
   */

  // Low bounds:
  class Node5[+T](x: T) {
    def sub[U >: T](v: U): Node5[U] = new Node5(v)
  }

  class Node6[T](x: T) {
    def sub[U >: T](v: U): Node6[U] = new Node6(v)
  }

  class Node7[-T](x: T) {
    def sub[U <: T](v: U): Node7[U] = new Node7(v)
  }

  println("==>main")
  println(bioPhony(Seq(new Animal, new Chicken)))
  println(bioPhony(Seq(new Bird, new Chicken)))

  // Error:inferred type arguments [String] do not conform to method bioPhony's type parameter bounds [T <: com.stulsoft.ysps.types.Animal]
  //  println(bioPhony(Seq(new String, new String)))

  // Low bounds
  println(new Node5(new Animal).sub(new Bird))
  println(new Node5(new Animal).sub(new Animal).sub(new Chicken))
  println(new Node5(new Bird).sub(new Bird))
  println(new Node5(new Bird).sub(new Chicken))
  println(new Node5(new Chicken).sub(new Bird))
  println(new Node5(new Chicken).sub(new Animal))
  println(new Node5(new Bird).sub(new Animal))
  println(new Node5(new Bird).sub(new Bird).sub(new Animal))
  println(new Node5(new Bird).sub(new Chicken))
  println(new Node5(new Bird).sub(new Bird).sub(new Chicken))

  println(new Node6(new Animal).sub(new Bird))
  println(new Node6(new Animal).sub(new Animal).sub(new Chicken))
  println(new Node6(new Bird).sub(new Bird))
  println(new Node6(new Bird).sub(new Chicken))
  println(new Node6(new Chicken).sub(new Bird))
  println(new Node6(new Chicken).sub(new Animal))
  println(new Node6(new Bird).sub(new Animal))
  println(new Node6(new Bird).sub(new Bird).sub(new Animal))
  println(new Node6(new Bird).sub(new Chicken))
  println(new Node6(new Bird).sub(new Bird).sub(new Chicken))

  println(new Node7(new Animal).sub(new Bird))
  println(new Node7(new Animal).sub(new Animal).sub(new Chicken))
  println(new Node7(new Bird).sub(new Bird))
  println(new Node7(new Bird).sub(new Chicken))
  // Error: println(new Node7(new Chicken).sub(new Bird))
  // Error: println(new Node7(new Chicken).sub(new Animal))
  // Error: println(new Node7(new Bird).sub(new Animal))
  // Error: println(new Node7(new Bird).sub(new Bird).sub(new Animal))
  println(new Node7(new Bird).sub(new Chicken))
  println(new Node7(new Bird).sub(new Bird).sub(new Chicken))
  println("<==main")
}
