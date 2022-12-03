package rockpaperscissors

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class StrategyGuideFileReaderIntegrationTest {

    @Test
    fun `when given a correctly formatted strategy guide file, should return the list of provided rounds`() {
        // Given
        val filename = "test-input-with-three-rounds"
        val expectedRoundSymbols = listOf(
            RoundSymbols('A', 'Y'),
            RoundSymbols('B', 'X'),
            RoundSymbols('C', 'Z'),
        )

        // When
        val rounds = StrategyGuideFileReader.read(filename)

        // Then
        assertEquals(expectedRoundSymbols, rounds)
    }
}
