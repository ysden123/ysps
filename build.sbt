import sbt.Keys.scalacOptions

lazy val loggingVersion = "2.14.1"

lazy val root = (project in file(".")).
  settings(
    name := "ysps",
    version := "1.0.10",
    scalaVersion := "2.13.6",
    javacOptions ++= Seq("-source", "11"),

    libraryDependencies ++= {
      Seq(
        "org.scala-lang.modules" %% "scala-parallel-collections" % "1.0.0",
        "com.typesafe.akka" %% "akka-actor" % "2.6.13",
        "com.typesafe" % "config" % "1.4.1",
        "org.scalatest" %% "scalatest" % "3.2.6" % Test,
        "com.novocode" % "junit-interface" % "0.11" % Test,

        "com.typesafe.scala-logging" %% "scala-logging" % "3.9.3",
        "org.apache.logging.log4j" % "log4j-api" % loggingVersion,
        "org.apache.logging.log4j" % "log4j-core" % loggingVersion,
        "org.apache.logging.log4j" % "log4j-slf4j-impl" % loggingVersion
      )
    },
    scalacOptions in(Compile, doc) ++= Seq("-author"),
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-language:implicitConversions",
      "-language:postfixOps"
      )
  )
