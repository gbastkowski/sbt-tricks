package name.bastkowski.sbttricks.integrationtesting

import org.scalatest._
import org.scalamock.scalatest.MockFactory

class UserServiceComponentSpec extends FreeSpec with MockFactory with Matchers {

  "The UserService" - {
    "Without any users" - {
      val serviceWithoutUsers = new UserService with UserRepositoryComponent {
        val userRepository = stub[UserRepository]
        (userRepository.authenticate _) when("", "") returns(None)
      }

      "Does not authenticate" in {
        serviceWithoutUsers.authenticate("", "") shouldBe None
      }
    }

    "With a matching user" - {
      lazy val gunnar = User("Gunnar", "secret")

      lazy val serviceWithUsers = new UserService with UserRepositoryComponent {
        val userRepository = stub[UserRepository]
        (userRepository.authenticate _) when("", "") returns(Some(gunnar))
      }

      "Does authenticate" in {
        serviceWithUsers.authenticate("", "") shouldBe Some(gunnar)
      }
    }
  }
}
