import Game._

import scala.util.Try

case class Game(line: String) {

  private val split = line.split(", ").map(_.split(' '))
  if (split.length != 2) throw new IllegalArgumentException("Invalid file format - application expects <teamA scoreA, teamB, scoreB> on each line")

  private val teamA = extractTeam(0)
  private val scoreA = extractScore(0)
  private val teamB = extractTeam(1)
  private val scoreB = extractScore(1)

  private def extractTeam(index: Int) =
    split(index).take(split(index).length - 1).mkString(" ")

  private def extractScore(index: Int) =
    Try(split(index).last.toInt).getOrElse(throw new IllegalArgumentException("Score could not be parsed"))

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
