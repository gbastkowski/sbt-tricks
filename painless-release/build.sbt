name                := "Painless Releases with sbt"
scalaVersion        := "2.12.6"
mainClass           := Some("name.bastkowski.sbttricks.Hello")
git.baseVersion     := "0.0.0"

enablePlugins(BuildInfoPlugin, GitVersioning)
buildInfoKeys       := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion)
buildInfoPackage    := "name.bastkowski.sbttricks"

git.useGitDescribe  := true
val VersionRegex = "v([0-9]+.[0-9]+.[0-9]+)-?(.*)?".r
git.gitTagToVersionNumber := {
  case VersionRegex(v,"")         => Some(v)
  case VersionRegex(v,"SNAPSHOT") => Some(s"$v-SNAPSHOT")
  case VersionRegex(v,s)          => Some(s"$v-$s-SNAPSHOT")
  case _                          => None
}
