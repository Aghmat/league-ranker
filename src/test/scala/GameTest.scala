import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class GameTest extends AnyFlatSpec with Matchers {
  "Game" should "be initialized correctly for valid construction" in {
    noException should be thrownBy Game("Tarantulas 1, FC Awesome 0")
  }

  "Game" should "throw an exception for an invalid construction" in {
    an [IllegalArgumentException] should be thrownBy Game("Tarantulas 1, FC Awesome 0, Snakes")
    an [IllegalArgumentException] should be thrownBy Game("Tarantulas 1, FC Awesome a")
    an [IllegalArgumentException] should be thrownBy Game("Tarantulas a, FC Awesome 1")
  }

  "calculatePoints" should "correctly calculate points" in {
    Game("Tarantulas 1, FC Awesome 0").calculatePoints() shouldBe Map("Tarantulas" -> Game.winPoints, "FC Awesome" -> Game.losePoints)
    Game("Tarantulas 0, FC Awesome 1").calculatePoints() shouldBe Map("Tarantulas" -> Game.losePoints, "FC Awesome" -> Game.winPoints)
    Game("Tarantulas 2, FC Awesome 2").calculatePoints() shouldBe Map("Tarantulas" -> Game.drawPoints, "FC Awesome" -> Game.drawPoints)
  }
}