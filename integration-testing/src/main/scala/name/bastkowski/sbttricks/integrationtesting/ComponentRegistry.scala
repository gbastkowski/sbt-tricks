package name.bastkowski.sbttricks.integrationtesting

object ComponentRegistry extends UserServiceComponentImpl {
  val userService    = new UserServiceImpl
  val userRepository = new UserRepositoryImpl
}
