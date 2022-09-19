case class Result(team: String, points: Int) {
  override def toString: String = {
    s"$team, $points ${if (points == 1) "pt" else "pts"}"
  }
}