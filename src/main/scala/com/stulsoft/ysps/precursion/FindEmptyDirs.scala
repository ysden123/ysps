/*
 * Copyright (c) 2022. Yuriy Stul
 */

package com.stulsoft.ysps.precursion

import java.nio.file.{Files, NoSuchFileException, Path, Paths}
import scala.jdk.CollectionConverters._
import scala.util.{Failure, Success, Using}

object FindEmptyDirs extends App {

  def findEmptyDirs(path: String): List[String] = {

    def predicateEmptyDir(p: Path): Boolean = {
      Using(Files.list(p)) {
        stream => stream.findAny().isEmpty
      } match {
        case Success(value) => value
        case Failure(exception) =>
          exception.printStackTrace()
          false
      }
    }

    Using(Files.walk(Paths.get(path))) {
      stream => {
        val result = stream.filter(f => Files.isDirectory(f))
          .filter(p => predicateEmptyDir(p))
          .map(p => p.toFile.getAbsolutePath)
          .toList
        List.from(result.asScala)
      }
    } match {
      case Success(emptyDirs) => emptyDirs
      case Failure(exception) => exception match {
        case _: NoSuchFileException =>
          println(s"Cannot find the file $path")
          Nil
        case exception: Exception =>
          println(exception.getMessage)
          Nil
      }
    }
  }

  val path = "."
  //  val path = "C:/Git/ysps"
  val emptyDirs = findEmptyDirs(path)
  println(s"""Empty dirs in the "$path"""")
  for (emptyDir <- emptyDirs)
    println(emptyDir)
}
