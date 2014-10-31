import sbt.Keys._
import sbt._


object Test extends Build {
  lazy val root = Project(
    id = "test",
    base = file("."))
    .settings(
      resolvers ++= Seq(
        "sonatypeSnapshots" at "http://oss.sonatype.org/content/repositories/snapshots"
      ),
      libraryDependencies ++= Seq(
        "com.typesafe.slick" %% "slick" % "2.1.0" withSources() withJavadoc(),
        "com.h2database" % "h2" % "1.3.170" withSources() withJavadoc(),
        "com.azavea.geotrellis" %% "geoslick" % "0.1.0-SNAPSHOT" withSources() withJavadoc()))
}