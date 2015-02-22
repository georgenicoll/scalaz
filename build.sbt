val orgScalaz = "org.scalaz"
val scalazVersion = "7.1.1"
val scalazDeps = Seq(
  orgScalaz %% "scalaz-core" % scalazVersion,
  orgScalaz %% "scalaz-effect" % scalazVersion,
  orgScalaz %% "scalaz-typelevel" % scalazVersion,
  orgScalaz %% "scalaz-scalacheck-binding" % scalazVersion % "test"
)
val scalatest = "org.scalatest" %% "scalatest" % "2.2.4" % "test"

lazy val commonSettings = Seq(
  organization := "org.monkeynuthead",
  version := "0.1.0",
  scalaVersion := "2.11.5",
  sbtVersion := "0.13.7",
  scalacOptions ++= Seq("-feature","-unchecked","-deprecation")
)

lazy val root = (project in file(".")).
  settings(commonSettings: _*).
  settings(
    name := "scalaz-tutorial",
    libraryDependencies ++= Seq(
      scalazDeps,
      Seq(scalatest)
    ).flatten,
    initialCommands in console := "import scalaz._, Scalaz._"
  )
