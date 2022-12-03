package rockpaperscissors

import rockpaperscissors.ScoreCalculator.Outcome.DRAW
import rockpaperscissors.ScoreCalculator.Outcome.LOSE
import rockpaperscissors.ScoreCalculator.Outcome.WIN
import rockpaperscissors.ScoreCalculator.Shape.PAPER
import rockpaperscissors.ScoreCalculator.Shape.ROCK
import rockpaperscissors.ScoreCalculator.Shape.SCISSORS

class ScoreCalculator {
    enum class Shape { ROCK, PAPER, SCISSORS }
    data class RoundShapes(val opponent: Shape, val selected: Shape)

    enum class Outcome { WIN, DRAW, LOSE }
    data class RoundWithElfRules(val opponentShape: Shape, val instruction: Outcome)

    fun getScore(roundsSymbols: List<RoundSymbols>): Int = toRounds(roundsSymbols).sumOf { round ->
        val selectedShapeScore = getShapeScore(round.selected)
        val roundOutcomeScore = getRoundOutcomeScore(round)

        selectedShapeScore + roundOutcomeScore
    }

    fun getScoreWithRealElfRules(roundSymbols: List<RoundSymbols>): Int =
        toRoundsWithElfRules(roundSymbols).sumOf { round ->
            val selectedShapeScore = getShapeScoreWithRealElfRules(round)
            val outcomeScoreWithRealElfRules = getOutcomeScore(round.instruction)

            selectedShapeScore + outcomeScoreWithRealElfRules
        }

    private fun toRounds(roundsSymbols: List<RoundSymbols>): List<RoundShapes> = roundsSymbols.map { symbols ->
        val opponentShape = when (symbols.opponent) {
            'A' -> ROCK
            'B' -> PAPER
            'C' -> SCISSORS
            else -> ROCK
        }
        val selectedShape = when (symbols.selected) {
            'X' -> ROCK
            'Y' -> PAPER
            'Z' -> SCISSORS
            else -> ROCK
        }

        RoundShapes(opponentShape, selectedShape)
    }

    private fun getRoundOutcomeScore(round: RoundShapes) = when (round.selected) {
        ROCK -> when (round.opponent) {
            PAPER -> getOutcomeScore(LOSE)
            ROCK -> getOutcomeScore(DRAW)
            else -> getOutcomeScore(WIN)
        }
        PAPER -> when (round.opponent) {
            SCISSORS -> getOutcomeScore(LOSE)
            PAPER -> getOutcomeScore(DRAW)
            else -> getOutcomeScore(WIN)
        }
        SCISSORS -> when (round.opponent) {
            ROCK -> getOutcomeScore(LOSE)
            SCISSORS -> getOutcomeScore(DRAW)
            else -> getOutcomeScore(WIN)
        }
    }

    private fun getShapeScoreWithRealElfRules(round: RoundWithElfRules): Int = when (round.opponentShape) {
        ROCK ->
            when (round.instruction) {
                LOSE -> getShapeScore(SCISSORS)
                DRAW -> getShapeScore(ROCK)
                else -> getShapeScore(PAPER)
            }
        PAPER ->
            when (round.instruction) {
                LOSE -> getShapeScore(ROCK)
                DRAW -> getShapeScore(PAPER)
                else -> getShapeScore(SCISSORS)
            }
        SCISSORS ->
            when (round.instruction) {
                LOSE -> getShapeScore(PAPER)
                DRAW -> getShapeScore(SCISSORS)
                else -> getShapeScore(ROCK)
            }
    }

    private fun getShapeScore(shape: Shape) = when (shape) {
        ROCK -> 1
        PAPER -> 2
        SCISSORS -> 3
    }

    private fun getOutcomeScore(outcome: Outcome) = when (outcome) {
        LOSE -> 0
        DRAW -> 3
        WIN -> 6
    }

    private fun toRoundsWithElfRules(roundSymbols: List<RoundSymbols>): List<RoundWithElfRules> =
        roundSymbols.map { symbols ->
            RoundWithElfRules(
                opponentShape = when (symbols.opponent) {
                    'A' -> ROCK
                    'B' -> PAPER
                    'C' -> SCISSORS
                    else -> ROCK
                },
                instruction = when (symbols.selected) {
                    'X' -> LOSE
                    'Y' -> DRAW
                    'Z' -> WIN
                    else -> LOSE
                }
            )
        }
}
