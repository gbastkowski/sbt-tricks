package name.bastkowski.sbttricks.integrationtesting


trait UserRepository {
  def authenticate(username: String, password: String): User

  def create(user: User): Unit

  def delete(user: User): Unit
}
