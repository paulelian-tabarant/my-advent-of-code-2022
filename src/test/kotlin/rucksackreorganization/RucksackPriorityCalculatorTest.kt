package rucksackreorganization

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class RucksackPriorityCalculatorTest {
    @Test
    fun `should sum the priorities of double items in each rucksack according to the weight of the double item symbol`() {
        // Given
        val rucksacks = RucksacksFileReader.readAsSplit("input-from-example")

        // When
        val sum = rucksacks.getSumOfSharedItemPriorities()

        // Then
        assertEquals(157, sum)
    }

    @Test
    fun `should sum the priorities of double items in each rucksack according to the weight of the double item symbol, with challenge input`() {
        // Given
        val rucksacks = RucksacksFileReader.readAsSplit("input")

        // When
        val sum = rucksacks.getSumOfSharedItemPriorities()

        // Then
        assertEquals(7763, sum)
    }

    @Test
    fun `should sum the priorities of each item which is common between each group of three rucksacks`() {
        // Given
        val rucksacks = RucksacksFileReader.read("input-from-example")

        // When
        val sum = rucksacks.getSumOfGroupsBadges()

        // Then
        assertEquals(70, sum)
    }

    @Test
    fun `should sum the priorities of each item which is common between each group of three rucksacks from challenge file`() {
        // Given
        val rucksacks = RucksacksFileReader.read("input")

        // When
        val sum = rucksacks.getSumOfGroupsBadges()

        // Then
        assertEquals(2569, sum)
    }
}