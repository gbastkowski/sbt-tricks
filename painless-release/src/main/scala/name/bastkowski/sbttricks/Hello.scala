package name.bastkowski.sbttricks

object Hello extends App {

  val name = BuildInfo.name
  val version = BuildInfo.version

  println(s"Hello, I'm $name, version $version")

}
