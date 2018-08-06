package name.bastkowski.sbttricks.integrationtesting

object ComponentRegistry
    extends UserServiceComponent
    with UserRepositoryComponent {

  lazy val userService    = new UserServiceImpl(userRepository)
  lazy val userRepository = new UserRepositoryImpl
}
