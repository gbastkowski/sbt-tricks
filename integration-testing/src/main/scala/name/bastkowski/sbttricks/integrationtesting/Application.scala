package name.bastkowski.sbttricks.integrationtesting

object Application extends App {

  println("Start")

  ComponentRegistry.userService.create("Gunnar", "secret")

  println("Finish")

}
