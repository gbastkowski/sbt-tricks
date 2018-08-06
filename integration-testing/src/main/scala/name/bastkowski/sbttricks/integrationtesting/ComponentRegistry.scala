package name.bastkowski.sbttricks.integrationtesting

object ComponentRegistry
  extends App
  with UserServiceComponentImpl
  with UserRepositoryComponentImpl
{
  println("Start")

  userService.create("Gunnar", "secret")

  println("Finish")
}
