
organization in Global  := "demo"

scalaVersion in Global  := "2.10.4"

lazy val demo = project.in(file(".")).aggregate(protocol, rpc)

lazy val protocol = project

lazy val rpc = project.dependsOn(protocol)
