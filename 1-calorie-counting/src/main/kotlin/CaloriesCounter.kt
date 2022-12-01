class CaloriesCounter {
    fun getSumOfMaxCaloriesSupply(supplies : List<ElfSupply>): Int {
        if (supplies.isEmpty()) return 0

        return getSums(supplies).max()
    }

    fun getSumOfThreeMaxCaloriesSupply(supplies: List<ElfSupply>): Int = getSums(supplies).sorted().takeLast(3).sum()

    private fun getSums(supplies: List<ElfSupply>) = supplies.map { it.calories.sum() }
}
