import sbt.Keys.scalacOptions

lazy val loggingVersion = "2.16.0"

lazy val root = (project in file(".")).
  settings(
    name := "ysps",
    version := "1.0.11",
    scalaVersion := "2.13.7",
    javacOptions ++= Seq("-source", "17"),

    libraryDependencies ++= {
      Seq(
        "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
        "com.typesafe.akka" %% "akka-actor" % "2.6.17",
        "com.typesafe" % "config" % "1.4.1",
        "org.scalatest" %% "scalatest" % "3.2.10" % Test,
        "com.novocode" % "junit-interface" % "0.11" % Test,

        "com.typesafe.scala-logging" %% "scala-logging" % "3.9.4",
        "org.apache.logging.log4j" % "log4j-api" % loggingVersion,
        "org.apache.logging.log4j" % "log4j-core" % loggingVersion,
        "org.apache.logging.log4j" % "log4j-slf4j-impl" % loggingVersion
      )
    },
    Compile / scalacOptions += "-author",
    doc / scalacOptions += "-author",
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-language:implicitConversions",
      "-language:postfixOps"
    )
  )
