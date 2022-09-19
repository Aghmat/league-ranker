import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class ResultTest extends AnyFlatSpec with Matchers {
  "toString" should "be valid for 1 point" in {
    Result("Lions", 1).toString shouldBe "Lions, 1 pt"
  }

  "toString" should "be valid for more than 1 point" in {
    Result("Lions", 2).toString shouldBe "Lions, 2 pts"
  }
}