import sbt.Keys.scalacOptions

lazy val loggingVersion = "2.19.0"

lazy val root = (project in file(".")).
  settings(
    name := "ysps",
    version := "1.0.13",
    scalaVersion := "2.13.10",
    javacOptions ++= Seq("-source", "17"),

    libraryDependencies ++= {
      Seq(
        "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.4",
        "com.typesafe.akka" %% "akka-actor" % "2.7.0",
        "com.typesafe" % "config" % "1.4.2",
        "org.scalatest" %% "scalatest" % "3.2.14" % Test,
        "com.novocode" % "junit-interface" % "0.11" % Test,

        "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
        "org.apache.logging.log4j" % "log4j-api" % loggingVersion,
        "org.apache.logging.log4j" % "log4j-core" % loggingVersion,
        "org.apache.logging.log4j" % "log4j-slf4j-impl" % loggingVersion
      )
    },
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-language:implicitConversions",
      "-language:postfixOps"
    )
  )
