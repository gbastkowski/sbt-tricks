package name.bastkowski.sbttricks.integrationtesting

trait UserService {

  def authenticate(username: String, password: String): User

  def create(username: String, password: String): Unit

  def delete(user: User): Unit

}
