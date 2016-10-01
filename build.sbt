lazy val root = (project in file(".")).
  settings(
    name := "ysps",
    version := "1.0.1",
    scalaVersion := "2.11.8",
    libraryDependencies ++= Seq(
      "com.typesafe.akka" %% "akka-actor" % "2.4.11",
    	"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test",
    	"com.novocode" % "junit-interface" % "0.11" % Test
    ),
    scalacOptions in (Compile, doc) ++= Seq("-author")
//    scalacOptions in (Compile, doc) ++= Seq("-author", "-diagrams-debug")
)