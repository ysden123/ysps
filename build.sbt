import sbt.Keys.scalacOptions

lazy val root = (project in file(".")).
  settings(
    name := "ysps",
    version := "1.0.8",
    scalaVersion := "2.13.3",
    javacOptions ++= Seq("-source", "11"),

    libraryDependencies ++= {
      Seq(
        "org.scala-lang.modules" %% "scala-parallel-collections" % "0.2.0",
        "com.typesafe.akka" %% "akka-actor" % "2.6.9",
        "com.typesafe.scala-logging" %% "scala-logging" % "3.9.2",
        "ch.qos.logback" % "logback-classic" % "1.2.3",
        "com.typesafe" % "config" % "1.4.0",
        "org.scalatest" %% "scalatest" % "3.0.8" % Test,
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