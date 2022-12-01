import java.io.File

object ElvesInputFileReader {

    fun read(filename: String): List<ElfSupply> {
        val file = File("src/test/resources/$filename")
        val elfSupplies = mutableListOf<ElfSupply>()
        var currentCalories = mutableListOf<Int>()

        file.forEachLine { line ->
            if (line.isEmpty()) {
                elfSupplies.add(ElfSupply(currentCalories))
                currentCalories = mutableListOf()
            } else {
                currentCalories.add(line.toInt())
            }
        }

        return elfSupplies
    }
}
