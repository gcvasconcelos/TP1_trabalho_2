scalaVersion := "2.12.4"

name := "Mini linguagem de Tecnicas de Programacao"
organization := "br.unb.cic"
version := "1.0"

libraryDependencies += "org.typelevel" %% "cats-core" % "1.0.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % "test"

parallelExecution in Test := false
