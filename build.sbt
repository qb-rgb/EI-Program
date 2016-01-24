name := "EI-Program"

version := "1.0"

scalacOptions += "-deprecation"

assemblyJarName in assembly := "program.jar"
mainClass in assembly := Some("programs.Main")
