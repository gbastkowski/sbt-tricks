package name.bastkowski.sbttricks.integrationtesting

trait UserServiceComponentImpl extends UserServiceComponent
  with UserRepositoryComponent
{
  val userService = new UserService {

    def authenticate(username: String, password: String): User = userRepository.authenticate(username, password)

    def create(username: String, password: String): Unit = userRepository.create(User(username, password))

    def delete(user: User): Unit = userRepository.delete(user)

  }
}
