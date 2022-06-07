fun main() {
    val k = 7
    val digits = MutableList(7) { i -> i + 1 }
    val per = MutableList(7) { i -> i + 1 }
    print(digits)
    getNextSequence(1, 0, 7, per, digits)

}

fun getNextSequence(
    count: Long,
    position: Int,
    size: Int,
    currentDigits: MutableList<Int>,
    availableDigits: MutableList<Int>
): Long {
    var c = count
    if (position == size) {
        println("$currentDigits $count")
        return c+1
    }
    for (digit in availableDigits) {
        currentDigits[position] = digit
        val newAvailableDigits = mutableListOf<Int>().apply{
            addAll(availableDigits)
            remove(digit)
        }
        c = getNextSequence(c, position + 1, size, currentDigits, newAvailableDigits)
    }
    return c
}