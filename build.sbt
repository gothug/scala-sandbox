name := "sandbox"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
//  "org.apache.spark" % "spark-core_2.10" % "1.6.2",
//  "org.apache.spark" % "spark-sql_2.10" % "1.6.2",
  "org.scalikejdbc" %% "scalikejdbc" % "2.4.2",
  "org.scalikejdbc" %% "scalikejdbc-interpolation" % "2.4.2",
  "org.postgresql" % "postgresql" % "9.3-1100-jdbc4",
  "org.json4s" %% "json4s-jackson" % "3.4.0"
)
