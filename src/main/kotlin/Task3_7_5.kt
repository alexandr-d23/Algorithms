import java.nio.file.Paths
import java.util.*
//задача о выборе заявок
fun main() {
    Task3_7_5().start()
}

class Task3_7_5 : BaseTask() {
    fun start() {
        scanner = getFileScanner()
        val n = scanner.nextInt()

        val list = mutableListOf<Request>()
        for (i in 0 until n) {
            val start = scanner.nextInt()
            val end = scanner.nextInt()
            list.add(
                Request(start, end)
            )
        }
        list.sortBy {
            it.end
        }
        var end = 0
        var count = 0
        for(i in 0 until n){
            if(list[i].start>=end){
                count++
                end = list[i].end
            }
        }
        println(count)
        println(n)
    }

    data class Request(
        val start: Int,
        val end: Int
    )
}