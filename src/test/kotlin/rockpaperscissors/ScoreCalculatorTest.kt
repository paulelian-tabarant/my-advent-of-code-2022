package rockpaperscissors

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ScoreCalculatorTest {
    @Test
    fun `when given a strategy guide, should compute the total score according to rock, paper, scissors rules`() {
        // Given
        val scoreCalculator = ScoreCalculator()
        val roundSymbols = listOf(
            RoundSymbols('A', 'Y'),
            RoundSymbols('B', 'X'),
            RoundSymbols('C', 'Z'),
        )

        // When
        val score = scoreCalculator.getScore(roundSymbols)

        // Then
        assertEquals(15, score)
    }

    @Test
    fun `when given a strategy guide from file, should compute the total score according to rock, paper, scissors rules`() {
        // Given
        val scoreCalculator = ScoreCalculator()
        val roundSymbols = StrategyGuideFileReader.read("input")

        // When
        val score = scoreCalculator.getScore(roundSymbols)

        // Then
        assertEquals(12740, score)
    }

    @Test
    fun `when given a strategy guide, should compute the total score according to rock, paper, scissors real elf rules`() {
        // Given
        val scoreCalculator = ScoreCalculator()
        val roundSymbols = listOf(
            RoundSymbols('A', 'Y'),
            RoundSymbols('B', 'X'),
            RoundSymbols('C', 'Z'),
        )

        // When
        val score = scoreCalculator.getScoreWithRealElfRules(roundSymbols)

        // Then
        assertEquals(12, score)
    }

    @Test
    fun `when given a strategy guide from file, should compute the total score according to rock, paper, scissors real elf rules`() {
        // Given
        val scoreCalculator = ScoreCalculator()
        val roundSymbols = StrategyGuideFileReader.read("input")

        // When
        val score = scoreCalculator.getScoreWithRealElfRules(roundSymbols)

        // Then
        assertEquals(11980, score)
    }
}
