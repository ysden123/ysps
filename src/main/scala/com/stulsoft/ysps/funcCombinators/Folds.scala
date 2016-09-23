package com.stulsoft.ysps.funcCombinators

/**
  * Playing with fold, foldLeft, and foldRight.
  *
  * Created by Yuriy Stul on 9/20/2016.
  */
object Folds {

  class Foo(val name: String, val age: Int, val sex: Symbol)

  object Foo {
    def apply(name: String, age: Int, sex: Symbol) = new Foo(name, age, sex)
  }

  def main(args: Array[String]): Unit = {
    println("==>main")
    foldTest()
    foldLeftTest()
    println("<==main")
  }

  def foldTest(): Unit = {
    println("==>foldTest")
    val fooList = Foo("Yuriy", 21, 'male) ::
      Foo("Olga", 20, 'female) ::
      Foo("Natasha", 15, 'female) ::
      Nil
    val r = fooList.fold("") {
      (z, i) => {
        println(s"z: $z, name: ${z.getClass.getName}")
        z match {
          case "" => i.asInstanceOf[Foo].name
          case _ => z + "|" + i.asInstanceOf[Foo].name
        }
      }
    }
    println(r)
    println("<==foldTest")
  }

  def foldLeftTest(): Unit = {
    println("==>foldLeftTest")
    val fooList = Foo("Yuriy", 21, 'male) ::
      Foo("Olga", 20, 'female) ::
      Foo("Natasha", 15, 'female) ::
      Nil
    val stringList = fooList.foldLeft(List[String]()) { (z, f) =>
      val title = f.sex match {
        case 'male => "Mr."
        case 'female => "Ms."
      }
      z :+ s"$title ${f.name} ${f.age}"
    }
    println(stringList)
    println(stringList(0))
    println(stringList(1))
    println(stringList(2))
    println("<==foldLeftTest")
  }
}
