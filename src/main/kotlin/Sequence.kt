fun main() {
    Task4_9_5().start()
}

class Task4_9_5 : BaseTask() {
    fun start() {
        scanner = getFileScanner()
        val n1 = scanner.nextInt()
        val firstSeq = mutableListOf<Int>()
        for (i in 0 until n1) {
            firstSeq.add(scanner.nextInt())
        }
        val n2 = scanner.nextInt()
        val secondSeq = mutableListOf<Int>()
        for (i in 0 until n2) {
            secondSeq.add(scanner.nextInt())
        }

        getCommonSequence(n1, firstSeq, n2, secondSeq)
    }
}

data class Cell(
    var count: Int = 0,
)

fun getCommonSequence(n1: Int, firstSeq: List<Int>, n2: Int, secondSeq: List<Int>)  {
    val cells = MutableList(n2 + 1) {
        MutableList(n1 + 1) {
            Cell()
        }
    }
    for (i in 1..n2) {
        cells[i][0].count = secondSeq[i - 1]
    }
    for (i in 1..n1) {
        cells[0][i].count = firstSeq[i - 1]
    }
    for (i in 1..n2) {
        var added = false
        for (j in 1..n1) {
            var leftCell = Cell()
            var topCell = Cell()
            if (j > 1) {
                leftCell = cells[i][j - 1].copy()
            }
            if (!added && cells[i][0] == cells[0][j]) {
                added = true
                leftCell.count += 1
            }
            if (i > 1) {
                topCell = cells[i - 1][j].copy()
            }
            cells[i][j] = if (topCell.count >= leftCell.count) {
                added = false
                topCell
            } else leftCell
        }
    }

    val history = mutableListOf<Int>()
    var i = n2
    var j = n1
    while (i > 0) {
        while (j > 0) {
            if (i == 1 && j == 1) {
                if (cells[i][j].count == 1) history.add(0)
                i = 0
                break
            }
            if (i > 1 && cells[i][j].count == cells[i - 1][j].count) {
                i--
                continue
            }
            if (j > 1) {
                val dif = cells[i][j].count - cells[i][j - 1].count
                if (dif == 1) {
                    history.add(j - 1)
                }
                j--
            }
        }
    }
    println(history.reversed().map {
        firstSeq[it]
    })
    val resultCell = cells[n2][n1]


    println()
    println(resultCell.count)
}