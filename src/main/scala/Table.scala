import scala.collection.mutable.ListBuffer

case class Table(games: Seq[Game]) {
  private def calculatedResults() = {
    games
      .flatMap(_.calculatePoints())
      .groupMapReduce(_._1)(_._2)(_ + _)
  }

  private def orderedResults() = {
    calculatedResults()
      .toSeq
      .sortBy { case (team, points) => (-points, team) }
      .map { case (team, points) => Result(team, points) }
  }

  override def toString: String = {
    val results = orderedResults()
    // Unfortunately a ranking algorithm is much simpler using side effects
    val rankings = ListBuffer.fill(results.size)(1)

    for (i <- 1 until rankings.length) {
      val rank = if (results(i).points == results(i - 1).points) rankings(i - 1) else i + 1
      rankings(i) = rank
    }

    results.zip(rankings).map { case (result, rank) =>
      s"$rank. ${result.toString}"
    }.mkString("\n")
  }
}