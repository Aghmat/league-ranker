import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

import java.io.FileNotFoundException
import scala.collection.mutable.Stack

class MainTest extends AnyFlatSpec with Matchers {
  "main" should "run for a valid text file" in {
    Main.main(Array("data.txt"))
  }

  "main" should "fail for a invalid arguments" in {
    an [IllegalArgumentException] should be thrownBy Main.main(Array.empty)
  }

  "main" should "fail for an invalid text file" in {
    an[FileNotFoundException] should be thrownBy Main.main(Array("invalid.file"))
  }
}