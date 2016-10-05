import sbt.Keys._

lazy val root = (project in file(".")).
  enablePlugins(PlayScala, BuildInfoPlugin).
  disablePlugins(PlayLayoutPlugin).
  settings(
    name := "play-as-a-lib",
    version := "1.0",
    scalaVersion := "2.11.8",
    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "seglo",
    libraryDependencies ++= Seq(ws)
  )

