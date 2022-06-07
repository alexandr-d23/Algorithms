import java.nio.file.Paths
import java.util.*
import kotlin.math.max

//задача о выборе заявок
fun main() {
    Task3_8_6().start()
}

class Task3_8_6 : BaseTask() {
    fun start() {
        scanner = getFileScanner()
        val n = scanner.nextInt()

        val list = MutableList(100000){
            0
        }
        for (i in 0 until n) {
            val start = scanner.nextInt()
            val end = scanner.nextInt()
            list[start]+=1
            list[end]-=1
        }

        var maxIntersection = 0
        var cur = 0
        for(i in 0 until list.size){
            cur+=list[i]
            maxIntersection = max(cur, maxIntersection)
        }

        println(maxIntersection)
        println(n)
    }

    data class Request(
        val start: Int,
        val end: Int
    )
}