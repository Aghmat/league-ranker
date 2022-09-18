case class Table(games: Seq[Game]) {
  private def calculateResults() = {
    games
      .flatMap(_.calculatePoints())
      .groupMapReduce(_._1)(_._2)(_ + _)
      .toSeq
      .sortBy { case (team, points) => (-points, team) }
      .map { case (team, points) => Result(team, points) }
  }

  override def toString: String = {
    calculateResults().zipWithIndex.map { case (result, index) =>
      val position = index + 1
      s"$position. ${result.toString}"
    }.mkString("\n")
  }
}