package name.bastkowski.sbttricks.integrationtesting

trait UserRepositoryComponentImpl extends UserRepositoryComponent {

  val userRepository = new UserRepository {

    def authenticate(username: String, password: String): Option[User] = {
      val user = User(username, password)
      println(s"authenticating $user")
      Some(user)
    }

    def create(user: User): User = {
      println(s"creating user:$user")
      user
    }

    def delete(user: User): Boolean = {
      println(s"deleting user:$user")
      true
    }

  }

}
