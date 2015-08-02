name := "TuringMachine"

version := "1.0"

scalaVersion := "2.11.4"

// Add test library dependancies

resolvers ++= Seq(
        "Sonatype Releases" at "http://oss.sonatype.org/content/repositories/releases",
        "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"
)

libraryDependencies ++= Seq(
        "org.specs2" %% "specs2" % "2.4.2" % "test",
        "org.scalatest" % "scalatest_2.11" % "2.2.1" % "test" )
