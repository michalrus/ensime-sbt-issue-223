scalaVersion in ThisBuild := "2.11.8"

lazy val AndroidSettings = android.Plugin.androidBuild ++ Seq(
    platformTarget in Android := "android-23"
  )

lazy val root = Project(id = "root", base = file("."))
  .settings(
    javacOptions in Compile := (javacOptions in (core, Compile)).value,
    scalacOptions in Compile := (scalacOptions in (core, Compile)).value
  )
  .aggregate(core)

lazy val core = Project(id = "core", base = file("core")).settings(
  AndroidSettings ++ Seq(
    name := "core"
  ): _*).dependsOn(sub).aggregate(sub)

lazy val sub = Project(id = "sub", base = file("sub")).settings(
  AndroidSettings ++ Seq(
    name := "sub"
  ): _*)
