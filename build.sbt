import sbt.Keys.compile

//Dependency Versions
val scalazVersion = "7.2.14"

lazy val commonSettings = Seq(
  organization := "org.anish",
  description := "Data Structures and Algorithms for coding interviews",
  version := "0.1.0-SNAPSHOT",
  scalaVersion := "2.12.5",
  scalacOptions ++= Seq("-target:jvm-1.8", "-deprecation", "-feature", "-unchecked", "-language:postfixOps"),
  javacOptions ++= Seq("-source", "1.8", "-target", "1.8"),
  compileOrder := CompileOrder.JavaThenScala
)

lazy val root: Project = Project(
  "ds-algo",
  file(".")
).settings(commonSettings)
  .aggregate(dsAlgoScala, dsAlgoJava)

lazy val dsAlgoJava: Project = Project(
  "ds-algo-java",
  file("java")
).settings(commonSettings)
  .settings(
    javaSource in Compile := baseDirectory.value,
    libraryDependencies ++= Seq(
      "junit" % "junit" % "4.12"
    ),
    // Java Style checks
    compile in Compile := ((compile in Compile) dependsOn (jcheckStyle in Compile)).value,
    compile in Test := ((compile in Test) dependsOn (jcheckStyle in Test)).value
  )

lazy val dsAlgoScala: Project = Project(
  "ds-algo-scala",
  file("scala")
).settings(commonSettings)
  .settings(
    scalaSource in Compile := baseDirectory.value,
    libraryDependencies ++= Seq(
      "org.scalaz" %% "scalaz-core" % scalazVersion
    ),
    wartremoverErrors in Compile ++= Warts.unsafe.filterNot(disableWarts.contains),
    compileScalastyle := scalastyle.in(Compile).toTask("").value,
    (compile in Compile) := ((compile in Compile) dependsOn compileScalastyle).value,
    fork in run := true
  )

lazy val compileScalastyle = taskKey[Unit]("compileScalastyle")

// Disable some warts
lazy val disableWarts = Set(Wart.Null,
  Wart.NonUnitStatements,
  Wart.Throw,
  Wart.Any)
