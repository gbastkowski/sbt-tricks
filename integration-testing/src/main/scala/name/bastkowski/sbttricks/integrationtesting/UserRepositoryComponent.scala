package name.bastkowski.sbttricks.integrationtesting

trait UserRepositoryComponent {
  val userRepository: UserRepository

  trait UserRepository {
    def authenticate(username: String, password: String): Option[User]

    def create(user: User): User

    def delete(user: User): Boolean
  }
}
