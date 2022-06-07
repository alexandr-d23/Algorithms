fun main() {
    val n = 35

    getextSequence(1, 0, n, 0, 1, MutableList(n) { 0 })
}


fun getextSequence(
    count: Long,
    ind: Int,
    sum: Int,
    taken: Int,
    last: Int,
    currentDigits: MutableList<Int>,
): Long {
    if (taken == sum) {
        println("${currentDigits.subList(0, ind)} $count")
        return count + 1
    }
    var c = count
    for (i in last..sum - taken) {
        currentDigits[ind] = i
        c = getextSequence(c, ind + 1, sum, taken + i, i, currentDigits)
    }
    return c
}