import sbt.Keys.scalacOptions

lazy val root = (project in file(".")).
  settings(
    name := "ysps",
    version := "1.0.3",
    scalaVersion := "2.12.5",

    libraryDependencies ++= {
      val akkaVersion = "2.4.14"
      Seq(
        "com.typesafe.akka" %% "akka-actor" % akkaVersion,
        "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
        "ch.qos.logback" % "logback-classic" % "1.1.2",
        "com.typesafe" % "config" % "1.3.1",
        "org.scalatest" %% "scalatest" % "3.0.1" % "test",
        "com.novocode" % "junit-interface" % "0.11" % Test
      )
    },
    scalacOptions in(Compile, doc) ++= Seq("-author"),
    scalacOptions ++= Seq(
      "-deprecation",
      "-feature",
      "-language:implicitConversions",
      "-language:postfixOps")
  )