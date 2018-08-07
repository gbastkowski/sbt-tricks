package name.bastkowski.sbttricks.integrationtesting

import scala.collection.mutable
import scalaz.Reader

trait UserRepositoryComponentImpl extends UserRepositoryComponent {

  val userRepository = new UserRepository {

    private[this] val users = mutable.Map[String, User]()

    def authenticate(username: String, password: String): Option[User] = users.get(username)

    def create(user: User): Option[User] = users.put(user.firstName, user)

    def delete(user: User): Option[User] = users.remove(user.firstName)

    def authenticate2(username: String, password: String) =
      Reader((userRepository: UserRepository) ⇒ userRepository.authenticate(username, password))
  }

}
