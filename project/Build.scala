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
        "com.github.tminglei" %% "slick-pg_jts" % "0.6.5.2" withSources() withJavadoc() exclude("org.postgresql", "postgresql"),
        "com.github.nscala-time" %% "nscala-time" % "1.4.0",
        "postgresql" % "postgresql" % "9.1-901.jdbc4" withSources() withJavadoc()))
}
