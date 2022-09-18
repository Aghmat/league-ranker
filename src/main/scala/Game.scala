import Game._

case class Game(line: String) {

  private val split = line.split(", ").map(_.split(' '))

  private val teamA = split(0).take(split(0).length - 1).mkString(" ")
  private val scoreA = split(0).last.toInt
  private val teamB = split(1).take(split(1).length - 1).mkString(" ")
  private val scoreB = split(1).last.toInt

  def calculatePoints(): Map[String, Int] = {
    val (pointsA, pointsB) = (scoreA, scoreB) match {
      case _ if scoreA > scoreB => winPoints -> losePoints
      case _ if scoreA < scoreB => losePoints -> winPoints
      case _ => drawPoints -> drawPoints
    }

    Map(teamA -> pointsA, teamB -> pointsB)
  }
}

object Game {
  final val losePoints: Int = 0
  final val drawPoints: Int = 1
  final val winPoints: Int = 3
}
