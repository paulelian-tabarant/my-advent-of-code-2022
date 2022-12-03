package rockpaperscissors

import java.io.File

object StrategyGuideFileReader {
    fun read(filename: String): List<RoundSymbols> {
        val file = File("src/test/resources/rockpaperscissors/$filename")

        val rounds = mutableListOf<RoundSymbols>()
        file.forEachLine { line ->
            val opponentChoice: Char = line.first()
            val myChoice: Char = line.last()
            rounds.add(RoundSymbols(opponentChoice, myChoice))
        }

        return rounds
    }
}
