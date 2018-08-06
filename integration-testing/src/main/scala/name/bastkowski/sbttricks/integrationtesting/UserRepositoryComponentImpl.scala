package name.bastkowski.sbttricks.integrationtesting

trait UserRepositoryComponentImpl extends UserRepositoryComponent {
  val userRepository = new UserRepositoryImpl
}
