package caloriecounting

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class CaloriesCounterTest {
    lateinit var caloriesCounter: CaloriesCounter

    @BeforeEach
    fun init() {
        caloriesCounter = CaloriesCounter()
    }

    @Test
    fun `should return 0 when no elf in the list`() {
        // Given
        val noSupply: List<ElfSupply> = emptyList()

        // When
        val actual = caloriesCounter.getSumOfMaxCaloriesSupply(noSupply)

        // Then
        assertEquals(0, actual)
    }

    @Test
    fun `when an only elf, should return the sum of each carried fruit`() {
        // Given
        val justOneElf = listOf(ElfSupply(listOf(1, 2, 3)))

        // When
        val actual = caloriesCounter.getSumOfMaxCaloriesSupply(justOneElf)

        // Then
        assertEquals(6, actual)
    }

    @Test
    fun `when several elves, should return the maximum sum between supplies`() {
        // Given
        val severalElves = listOf(
            ElfSupply(listOf(3, 3, 5)),
            ElfSupply(listOf(9, 9)),
            ElfSupply(listOf(1, 2, 3, 4))
        )

        // When
        val actual = caloriesCounter.getSumOfMaxCaloriesSupply(severalElves)

        // Then
        assertEquals(18, actual)
    }

    @Test
    fun `should return the maximum sum of every elf supply`() {
        // Given
        val elvesFromFile = ElvesInputFileReader.read("input")

        // When
        val actual = caloriesCounter.getSumOfMaxCaloriesSupply(elvesFromFile)

        // Then
        assertEquals(69836, actual)
    }

    @Test
    fun `should return the sum of the 3 maximum calories supplies`() {
        // Given
        val severalElves = listOf(
            ElfSupply(listOf(40)),
            ElfSupply(listOf(9, 9)),
            ElfSupply(listOf(40)),
            ElfSupply(listOf(1, 2, 3, 3)),
            ElfSupply(listOf(40))
        )

        // When
        val actual = caloriesCounter.getSumOfThreeMaxCaloriesSupply(severalElves)

        // Then
        assertEquals(40 + 40 + 40, actual)
    }

    @Test
    fun `should return the sum of the 3 maximum calories supplies from file`() {
        // Given
        val severalElves = ElvesInputFileReader.read("input")

        // When
        val actual = caloriesCounter.getSumOfThreeMaxCaloriesSupply(severalElves)

        // Then
        assertEquals(207968, actual)
    }
}
