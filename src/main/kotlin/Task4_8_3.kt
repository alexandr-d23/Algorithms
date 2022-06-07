import java.util.Scanner

fun main() {
    val t = Task4_8_3()
    t.start()
}

class Task4_8_3 {
    fun start() {
        val scanner = Scanner(System.`in`)
        val n = scanner.nextInt()
        val m = scanner.nextInt()
        val cells = MutableList<MutableList<Step>>(n) {
            MutableList(m) {
                Step()
            }
        }
        for (i in 0 until n) {
            for (j in 0 until m) {
                cells[i][j].bonuses = scanner.nextInt()
            }
        }

        for (i in 1 until m) {
            cells[0][i].apply {
                way = cells[0][i - 1].way + 'R'
                bonuses += cells[0][i-1].bonuses
            }
        }

        for (i in 1 until n) {
            cells[i][0].apply {
                way = cells[i - 1][0].way + 'D'
                bonuses += cells[i - 1][0].bonuses
            }
            for (j in 1 until m) {
                if(cells[i][j - 1].bonuses > cells[i-1][j].bonuses){
                    cells[i][j].apply {
                        cells[i][j-1].let { c ->
                            bonuses += c.bonuses
                            way = c.way + 'R'
                        }
                    }
                }
                else {
                    cells[i][j].apply {
                        cells[i-1][j].let { c ->
                            bonuses += c.bonuses
                            way = c.way + 'D'
                        }
                    }
                }
            }
        }

        println(cells[n-1][m-1])
    }
}

data class Step(
    var way: String = "",
    var bonuses: Int = 0
)