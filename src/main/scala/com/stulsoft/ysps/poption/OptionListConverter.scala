package com.stulsoft.ysps.poption

/**
  * @author Yuriy Stul.
  */
object OptionListConverter {
  /**
    * Extracts only significant items of a collection.
    *
    * @param collection the collection with Some or None objects
    * @tparam T type of the values
    * @return collection with significant items.
    */
  def extract[T](collection: Traversable[Option[T]]): Traversable[T] = {
    collection.filter(_.isDefined).map(_.get)
  }
}

object OptionListConverterTest extends App {
  val l: List[Option[String]] = List(Some("text1"), None, Some("text2"))
  println(s"l: $l")
  val r1 = OptionListConverter.extract(l)
  println(s"r1: $r1")
  val r2 = OptionListConverter.extract(l)
  println(s"r2: $r2")

  val v: Vector[Option[String]] = Vector(Some("text1"), None, Some("text2"))
  val r3 = OptionListConverter.extract(v)
  println(s"r3: $r3")

  val v2: Vector[Option[String]] = Vector(None, None, None)
  val r4 = OptionListConverter.extract(v2)
  println(s"r4: $r4")
}