import java.nio.file.Paths
import java.util.*

fun main() {
    Bag().start()
}

class Bag {
    fun start() {
        val scanner = Scanner(Paths.get("src/main/kotlin/data.in"))
        val n = scanner.nextInt()
        val w = scanner.nextInt()
        val items = mutableListOf<Item>()
        for (i in 0 until n) {
            items.add(
                Item(
                    scanner.nextInt(),
                    scanner.nextInt()
                )
            )
        }
        val matrix = MutableList(w + 1) {
            MutableList(n) {
                0
            }
        }
        for (i in items[0].w until matrix.size) {
            matrix[i][0] = items[0].cost
        }

        for (j in 0 until n - 1) {
            for (i in 1..w) {
                if (matrix[i][j] != 0) {
                    if (matrix[i][j] > matrix[i][j + 1]) matrix[i][j + 1] = matrix[i][j]
                    if (i + items[j + 1].w <= w) {
                        matrix[i + items[j + 1].w][j + 1] = matrix[i][j] + items[j + 1].cost
                    }
                }
            }
        }

        var h = w
        val history = mutableListOf<Int>()
        for(i in n-1 downTo 1){
            if(matrix[h][i] != matrix[h][i - 1 ]){
                history.add(i)
                h -= items[i].w
            }
        }
        if(matrix[h][0] != 0){
            history.add(0)
        }
        var sum = 0
        for(i in history){
            sum += items[i].cost
        }
        println(sum)
        println(history.reversed().map {
            it+1
        })

        println(matrix[w][n - 1])
    }

    data class Item(
        var w: Int,
        var cost: Int
    )
}