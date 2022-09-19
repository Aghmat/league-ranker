import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class TableTest extends AnyFlatSpec with Matchers {
  "orderedResults" should "correctly calculate and order results" in {
    val games = Seq(
      Game("Lions 3, Snakes 3"),
      Game("Tarantulas 1, FC Awesome 0"),
      Game("Lions 1, FC Awesome 1"),
      Game("Tarantulas 3, Snakes 1"),
      Game("Lions 4, Grouches 0")
    )

    val expectedOutput =
      """1. Tarantulas, 6 pts
        |2. Lions, 5 pts
        |3. FC Awesome, 1 pt
        |3. Snakes, 1 pt
        |5. Grouches, 0 pts""".stripMargin.replaceAll("\r", "")

    Table(games).toString shouldEqual  expectedOutput
  }
}

