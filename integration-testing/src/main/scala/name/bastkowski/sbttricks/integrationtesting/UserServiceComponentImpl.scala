package name.bastkowski.sbttricks.integrationtesting

trait UserServiceComponentImpl
  extends UserServiceComponent
  with UserRepositoryComponentImpl
{
  val userService = new UserServiceImpl(userRepository)
}
