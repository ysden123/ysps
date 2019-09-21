import sbt.Keys.scalacOptions

lazy val root = (project in file(".")).
  settings(
    name := "ysps",
    version := "1.0.7",
    scalaVersion := "2.13.1",
    javacOptions ++= Seq("-source", "11"),

    libraryDependencies ++= {
      Seq(
        "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
        "com.typesafe.akka" %% "akka-actor" % "2.5.23",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
        "ch.qos.logback" % "logback-classic" % "1.2.3",
        "com.typesafe" % "config" % "1.3.4",
        "org.scalatest" %% "scalatest" % "3.0.8" % "test",
        "com.novocode" % "junit-interface" % "0.11" % Test
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