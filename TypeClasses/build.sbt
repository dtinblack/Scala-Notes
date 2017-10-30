name := "FunctionSignatures"

version := "1.0"

scalaVersion := "2.12.0"

libraryDependencies ++= Seq(
  "org.specs2" %% "specs2-core" % "4.0.0" % "test",
  // the scalacheck lib will come as a transitive
  // dependency
  "org.specs2" %% "specs2-scalacheck" % "4.0.0" % "test"
)
