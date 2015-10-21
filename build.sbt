lazy val appSettings = Seq(
  organization := "org.x4444",
  name := "machine-learning",
  version := "1.0.0"
)

// Those settings should be the same as in alchemy!
lazy val scalaVersion_ = "2.11.7" // should be the same as spark
lazy val javaVersion = "1.7" // should be the same as spark

lazy val scalaTestVersion = "2.2.4"

scalaVersion in Global := scalaVersion_

scalacOptions in Global ++= Seq(
  "-deprecation",
  "-feature",
  "-target:jvm-" + javaVersion,
  "-Xfatal-warnings",
  "-Xlint"
)

javacOptions in Global ++= Seq(
  "-encoding", "UTF-8",
  "-source", javaVersion,
  "-target", javaVersion
)

lazy val auxLib = Seq(
  "org.apache.commons" % "commons-math3" % "3.2"
)

lazy val testLib = Seq(
  "org.scalatest" %% "scalatest" % scalaTestVersion % Test withSources() withJavadoc()
)

lazy val root = (project in file("."))
  .settings(appSettings: _*)
  .settings(
    libraryDependencies ++= auxLib,
    libraryDependencies ++= testLib
  )

