fun main() {
    Task5_8_3().start()
}

class Task5_8_3 : BaseTask() {
    fun start() {
        scanner = getFileScanner()
        val n = scanner.nextInt()
        for (i in 0 until n) {
            var d = scanner.nextInt()
            var c = 0
            while (d > 0) {
                if (d % 2 == 1) c++
                d = d shr 1
//                println(d)
            }
            print("$c ")
        }
    }
}