package name.bastkowski.sbttricks.integrationtesting

class UserRepository {
  def authenticate(username: String, password: String): User = {
    val user = User(username, password)
    println(s"authenticating $user")
    user
  }
  def create(user: User): Unit = println(s"creating user:$user")
  def delete(user: User): Unit = println(s"deleting user:$user")
}