package name.bastkowski.sbttricks.integrationtesting

class UserServiceImpl(repository: UserRepository) extends UserService {

  def authenticate(username: String, password: String): User = repository.authenticate(username, password)

  def create(username: String, password: String): Unit = repository.create(User(username, password))

  def delete(user: User): Unit = repository.delete(user)

}
