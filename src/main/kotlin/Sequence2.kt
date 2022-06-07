fun main() {
    Task4_8_6().start()
}

class Task4_8_6 : BaseTask() {
    fun start() {
        scanner = getFileScanner()
        val n1 = scanner.nextInt()
        val firstSeq = mutableListOf<Int>()
        for (i in 0 until n1) {
            firstSeq.add(scanner.nextInt())
        }
        val n2 = n1
        val secondSeq =firstSeq.sorted()
        getCommonSequence(n1, firstSeq, n2, secondSeq)
    }

}