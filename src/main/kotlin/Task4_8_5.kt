fun main() {
    Task4_8_5().start()
}

class Task4_8_5 : BaseTask() {
    fun start() {
        scanner = getFileScanner()
        val n = scanner.nextInt()
        val s = scanner.nextInt()
        val coins = mutableListOf<Int>()
        for (i in 0 until n) {
            coins.add(scanner.nextInt())
        }
        val sums = MutableList(s + 1) {
            s
        }
        sums[0] = 0
        for (i in 1..s) {
            for (j in 0 until n) {
                if (i - coins[j] >= 0 && sums[i - coins[j]] + 1 < sums[i]) {
                    sums[i] = sums[i - coins[j]] + 1
                }
            }
        }

        println(sums[s])
    }
}