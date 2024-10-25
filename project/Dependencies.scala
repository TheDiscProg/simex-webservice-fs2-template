import sbt.*

object Dependencies {

  private lazy val sharepriceConfig = "0.12.0"
  private lazy val fs2Version = "3.11.0"
  private lazy val http4sVersion = "0.23.29"
  private lazy val blazeVersion = "0.23.16"

  lazy val all = Seq(
    "Shareprice" %% "shareprice-config" % sharepriceConfig,
    "co.fs2" %% "fs2-core" % fs2Version,
    "co.fs2" %% "fs2-io" % fs2Version,
    "org.http4s" %% "http4s-dsl" % http4sVersion,
    "org.http4s" %% "http4s-circe" % http4sVersion,
    "org.http4s" %% "http4s-blaze-core" % blazeVersion,
    "org.http4s" %% "http4s-blaze-server" % blazeVersion,
    "org.http4s" %% "http4s-blaze-client" % blazeVersion,
    "ch.qos.logback" % "logback-classic" % "1.5.8",
    "org.typelevel" %% "log4cats-core" % "2.7.0",
    "org.typelevel" %% "log4cats-slf4j" % "2.7.0",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.9.5",
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test,
    "org.scalatest" %% "scalatest" % "3.2.19" % Test,
    "org.scalatestplus" %% "mockito-4-6" % "3.2.15.0" % Test
  )
}
