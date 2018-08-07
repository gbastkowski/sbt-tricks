package name.bastkowski.sbttricks.integrationtesting

object ComponentRegistry extends UserRepositoryComponentImpl {
  val userService = new UserService with UserRepositoryComponentImpl
}
