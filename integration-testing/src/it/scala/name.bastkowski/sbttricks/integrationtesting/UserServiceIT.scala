package name.bastkowski.sbttricks.integrationtesting

import org.scalatest._

class UserServiceIT extends FreeSpec with Matchers {
  "A UserService" - {
    "with one existing user" - {
      "Authenticates the user" in {
        ComponentRegistry.userService.authenticate("Gunnar","secret") shouldBe Some(User("Gunnar", "secret"))
      }
    }
  }
}
