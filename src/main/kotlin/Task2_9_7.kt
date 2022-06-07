fun main() {
    val t = Task29_7()
    t.start()
}

class Task29_7 {

    fun start() {
        val n = 25
        val m = 8
        val digits = MutableList(n) { 0 }
        getNextSequence(1, 0, m, 1, n, digits)
    }

    fun getNextSequence(
        count: Long,
        ind: Int,
        zeroAvailable: Int,
        previousDigit: Int,
        size: Int,
        currentDigits: MutableList<Int>,
    ): Long {
        if (ind + zeroAvailable > size) {
            return count
        }
        if (ind == size) {
            if (count == 24008L) println("${currentDigits} $count")
            return count + 1
        }
        var c = count
        if (zeroAvailable > 0 && previousDigit == 1) {
            currentDigits[ind] = 0
            c = getNextSequence(c, ind + 1, zeroAvailable - 1, 0, size, currentDigits)
        }
        currentDigits[ind] = 1
        c = getNextSequence(c, ind + 1, zeroAvailable, 1, size, currentDigits)
        return c
    }
}