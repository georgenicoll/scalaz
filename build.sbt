val scalaz = "org.scalaz" %% "scalaz-core" % "7.1.1"
val scalatest = "org.scalatest" %% "scalatest" % "2.2.4"

lazy val commonSettings = Seq(
  organization := "org.monkeynuthead",
  version := "0.1.0",
  scalaVersion := "2.11.5"
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "scalaz-tutorial",
    libraryDependencies ++= Seq(scalaz, scalatest)
  )
