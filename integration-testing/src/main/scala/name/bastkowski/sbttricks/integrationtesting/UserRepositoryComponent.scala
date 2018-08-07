package name.bastkowski.sbttricks.integrationtesting

trait UserRepositoryComponent {
  val userRepository: UserRepository

  trait UserRepository {
    def authenticate(username: String, password: String): Option[User]

    def create(user: User): Option[User]

    def delete(user: User): Option[User]
  }
}
