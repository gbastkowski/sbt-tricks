package name.bastkowski.sbttricks.integrationtesting

import org.scalatest._

class UserServiceComponentSpec extends FreeSpec with Matchers {

  "The UserService" - {
    "Without any users" - {
      val serviceWithoutUsers = new UserServiceComponentImpl with UserRepositoryComponent {
        val userRepository = new UserRepository {
          def authenticate(username: String, password: String): Option[User] = None

          def create(user: User): User = user

          def delete(user: User): Boolean = true
        }
      }.userService

      "Does not authenticate" in {
        serviceWithoutUsers.authenticate("", "") shouldBe None
      }
    }

    "With a matching user" - {
      val gunnar = User("Gunnar", "secret")
      val serviceWithUsers = new UserServiceComponentImpl with UserRepositoryComponent {
        val userRepository = new UserRepository {
          def authenticate(username: String, password: String): Option[User] = Some(gunnar)

          def create(user: User): User = user

          def delete(user: User): Boolean = true
        }
      }.userService

      "Does authenticate" in {
        serviceWithUsers.authenticate("", "") shouldBe Some(gunnar)
      }
    }
  }
}
