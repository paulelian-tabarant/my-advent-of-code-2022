package rucksackreorganization

data class SplitRucksack(val first: String, val second: String) {
    fun findDoubleItem() = first.find { firstRucksackChar -> second.any { firstRucksackChar == it } }!!
}
