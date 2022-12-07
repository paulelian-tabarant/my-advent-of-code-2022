package rucksackreorganization

import java.io.File

object RucksacksFileReader {

    fun readAsSplit(filename: String): List<SplitRucksack> {
        val file = File("src/test/resources/rucksacksreorganization/$filename")

        val rucksacks = mutableListOf<SplitRucksack>()
        file.forEachLine { line ->
            val rucksackSize = line.length / 2
            val rucksack = SplitRucksack(
                first = line.substring(0 until rucksackSize),
                second = line.substring(rucksackSize until line.length)
            )
            rucksacks.add(rucksack)
        }

        return rucksacks
    }

    fun read(filename: String): List<Rucksack> {
        val file = File("src/test/resources/rucksacksreorganization/$filename")

        val rucksacks = mutableListOf<Rucksack>()
        file.forEachLine { line ->
            rucksacks.add(Rucksack(line))
        }

        return rucksacks
    }
}