fun main() {
    Task3_7_7().start()
}

class Task3_7_7 : BaseTask() {
    fun start() {
        scanner = getFileScanner()
        val n = scanner.nextInt()
        val distance = scanner.nextInt()
        val oilDistance = scanner.nextInt()
        var count = 0
        var nextStop = oilDistance
        var possibleStop = 0
        for (i in 0 until n) {
            val loc = scanner.nextInt()
            if (loc <= nextStop) {
                possibleStop = loc
                if (possibleStop + oilDistance >= distance) {
                    count++
                    break
                }
            } else {
                count++
                nextStop = possibleStop + oilDistance
                if (nextStop < distance && possibleStop + oilDistance >= distance) {
                    count++
                }
                if (nextStop >= distance) break
                possibleStop = loc
            }
        }
        println(count)
    }
}