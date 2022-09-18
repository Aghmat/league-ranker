import scala.io.Source
import scala.util.Using

object Main {
  final val losePoints: Int = 0
  final val drawPoints: Int = 1
  final val winPoints: Int = 3

  def main(args: Array[String]): Unit = {
    val fileName = args(0)

    Using(Source.fromFile(fileName)) { source =>
      val games = source.getLines().map(new Game(_)).toSeq
      val table = Table(games)
      print(table.toString())
    }
  }
}
