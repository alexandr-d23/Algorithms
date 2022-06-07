import java.math.BigInteger
import kotlin.math.max

//задача о выборе заявок
fun main() {
    Task3_8_7().start()
}

class Task3_8_7 : BaseTask() {
    fun start() {
        scanner = getFileScanner()
        val n = scanner.nextInt()
        var t = scanner.nextInt()
        val list = mutableListOf<Int>()
        for(i in 0 until n){
            list.add(scanner.nextInt())
        }
        list.sort()

        var currentTime = 0
        var wholeTime = 0
        var count = 0
        for(d in list){
            if(d < t){
                wholeTime+=d
                t-=d
                currentTime += wholeTime
                count++
            }
        }
        println(count)
        println(currentTime)

    }
}