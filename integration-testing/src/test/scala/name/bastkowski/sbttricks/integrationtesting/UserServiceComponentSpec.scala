package name.bastkowski.sbttricks.integrationtesting

import org.scalatest._

class UserServiceComponentSpec extends FunSpec with Matchers {

  describe("Without any users") {
    val serviceWithoutUsers = new UserServiceComponentImpl with UserRepositoryComponent {
      val userRepository = new UserRepository {
        def authenticate(username: String, password: String): Option[User] = None

        def create(user: User): User = user

        def delete(user: User): Boolean = true
      }
    }.userService

    it("Does not authenticate") {
      serviceWithoutUsers.authenticate("", "") shouldBe None
    }
  }

  describe("With a matching user") {
    val gunnar = User("Gunnar", "secret")
    val serviceWithUsers = new UserServiceComponentImpl with UserRepositoryComponent {
      val userRepository = new UserRepository {
        def authenticate(username: String, password: String): Option[User] = Some(gunnar)

        def create(user: User): User = user

        def delete(user: User): Boolean = true
      }
    }.userService

    it("Does authenticate") {
      serviceWithUsers.authenticate("", "") shouldBe Some(gunnar)
    }
  }
}
