package name.bastkowski.sbttricks.integrationtesting

import org.scalatest._
import org.scalamock.scalatest.MockFactory

class UserServiceComponentSpec extends FreeSpec with MockFactory with Matchers {

  "The UserService" - {
    "Without any users" - {
      val serviceWithoutUsers = new UserServiceComponentImpl with UserRepositoryComponent {
        val userRepository = stub[UserRepository]
        (userRepository.authenticate _) when("", "") returns(None)
      }.userService

      "Does not authenticate" in {
        serviceWithoutUsers.authenticate("", "") shouldBe None
      }
    }

    "With a matching user" - {
      lazy val gunnar = User("Gunnar", "secret")

      lazy val serviceWithUsers = new UserServiceComponentImpl with UserRepositoryComponent {
        val userRepository = stub[UserRepository]
        (userRepository.authenticate _) when("", "") returns(Some(gunnar))
      }.userService

      "Does authenticate" in {
        serviceWithUsers.authenticate("", "") shouldBe Some(gunnar)
      }
    }
  }
}
