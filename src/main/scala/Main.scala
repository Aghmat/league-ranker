import java.io.FileNotFoundException
import scala.io.Source
import scala.util.{Try, Using}
import java.io.File

object Main {
  def main(args: Array[String]): Unit = {
    val fileName = Try(args(0)).getOrElse(throw new IllegalArgumentException("Please provide a valid file name"))

    val fileExists = new File(fileName).exists()
    lazy val currentDirectory = new java.io.File(".").getCanonicalPath
    if (!fileExists) throw new FileNotFoundException(s"$fileName: not found in $currentDirectory")

    Using(Source.fromFile(fileName)) { source =>
      val games = source.getLines().map(new Game(_)).toSeq
      val table = Table(games)
      println(table.toString())
    }
  }
}
