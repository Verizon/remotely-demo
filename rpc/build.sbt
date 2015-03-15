
addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0-M5" cross CrossVersion.full)

libraryDependencies ++= Seq(
  "org.scala-lang"   % "scala-reflect" % scalaVersion.value,
  "org.scalamacros" %% "quasiquotes"   % "2.1.0-M5"
)

Revolver.settings
