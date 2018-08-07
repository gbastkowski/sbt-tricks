package name.bastkowski.sbttricks.integrationtesting

import scalaz.Reader

trait UserService extends UserRepositoryComponent {

  def authenticate(username: String, password: String): Option[User] = run { find(username, password) }

  private[this] def run[A](reader: Reader[UserRepository, A]): A =
    reader(userRepository)

  private[this] def find(username: String, password: String) =
    Reader((userRepository: UserRepository) ⇒ userRepository.authenticate(username, password))

  def create(username: String, password: String): Option[User] = run {
    Reader((userRepository: UserRepository) ⇒ userRepository.create(User(username, password)))
  }

  def remove(user: User): Boolean = run { for {
      previous ← delete(user)
    } yield previous.isDefined
  }

  private[this] def delete(user: User) = Reader((userRepository: UserRepository) ⇒ userRepository.delete(user))

}
