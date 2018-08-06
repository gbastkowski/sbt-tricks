package name.bastkowski.sbttricks.integrationtesting

trait UserServiceComponent { this: UserRepositoryComponent ⇒
  val userService: UserService
}
