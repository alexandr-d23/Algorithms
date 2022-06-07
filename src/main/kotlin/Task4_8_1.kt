import kotlin.math.max

fun main() {
    val t = Task4_8_1()
    t.start()
}

class Task4_8_1 {
    fun start() {
        val n = 100000
        val m = 1000000000
        var even = 1
        var odd = 1
        for (i in 2..n) {
            if (i % 2 == 0) {
                even += odd % m
                even %= m
            } else {
                odd += even % m
                odd %= m
            }
        }
        if (n % 2 == 0) println(even)
        else println(odd)
    }
}