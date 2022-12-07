package rucksackreorganization

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class RucksacksFileReaderTest {
    @Test
    fun `when given a rucksack formatted file, it should output a list of rucksacks containing correctly split compartments`() {
        // Given
        val filename = "test-input"
        val expectedRucksacks = listOf(
            SplitRucksack("vJrwpWtwJgWr", "hcsFMMfFFhFp"),
            SplitRucksack("jqHRNqRjqzjGDLGL", "rsFMfFZSrLrFZsSL")
        )

        // When
        val rucksacks = RucksacksFileReader.readAsSplit(filename)

        // Then
        assertEquals(expectedRucksacks, rucksacks)
    }

    @Test
    fun `when given a rucksack formatted file, it should output a list of rucksacks`() {
        // Given
        val filename = "test-input"
        val expectedRucksacks = listOf(
            Rucksack("vJrwpWtwJgWrhcsFMMfFFhFp"),
            Rucksack("jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL")
        )

        // When
        val rucksacks = RucksacksFileReader.read(filename)

        // Then
        assertEquals(expectedRucksacks, rucksacks)
    }
}