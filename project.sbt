
organization in Global  := "demo"

scalaVersion in Global  := "2.11.4"

val protocol = project

val client = project.dependsOn(protocol)

val server = project.dependsOn(protocol)
