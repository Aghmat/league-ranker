import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import scala.collection.mutable.Stack

class MainTest extends AnyFlatSpec with Matchers {
  "main" should "work" in {
    Main.main(Array("data.txt"))
  }
}