package name.bastkowski.sbttricks.integrationtesting

trait UserServiceComponent { this: UserRepositoryComponent ⇒
  val userService: UserService

  trait UserService {

    def authenticate(username: String, password: String): Option[User]

    def create(username: String, password: String): Unit

    def delete(user: User): Unit

  }
}
