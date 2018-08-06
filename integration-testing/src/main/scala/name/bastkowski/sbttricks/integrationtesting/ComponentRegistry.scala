package name.bastkowski.sbttricks.integrationtesting

object ComponentRegistry
    extends UserServiceComponent
    with UserRepositoryComponent {

  lazy val userService    = new UserService(userRepository)
  lazy val userRepository = new UserRepository
}
