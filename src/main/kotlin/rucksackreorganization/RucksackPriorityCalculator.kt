package rucksackreorganization

private const val FIRST_LOWER_PRIORITY = 1
private const val FIRST_UPPER_PRIORITY = 27

private const val GROUP_SIZE = 3

fun List<SplitRucksack>.getSumOfSharedItemPriorities(): Int = this.sumOf { rucksack -> getSharedItemPriority(rucksack) }

fun List<Rucksack>.getSumOfGroupsBadges(): Int {
    var remaining = this
    var sum = 0
    while (remaining.isEmpty().not()) {
        val group = remaining.take(GROUP_SIZE)
        remaining = remaining.drop(GROUP_SIZE)

        sum += getSharedItem(group).getPriority()
    }

    return sum
}


private fun getSharedItem(group: List<Rucksack>) =
    group[0].content.find { item -> group[1].hasItem(item) && group[2].hasItem(item) }!!

private fun getSharedItemPriority(rucksack: SplitRucksack): Int = rucksack.findDoubleItem().getPriority()

private fun Char.getPriority(): Int = if (isLowerCase()) toLowercasePriority() else toUppercasePriority()

private fun Char.toUppercasePriority() = FIRST_UPPER_PRIORITY + code - 'A'.code

private fun Char.toLowercasePriority() = FIRST_LOWER_PRIORITY + code - 'a'.code