package rucksackreorganization

data class Rucksack(val content: String) {
    fun hasItem(item: Char) = content.contains(item)
}
