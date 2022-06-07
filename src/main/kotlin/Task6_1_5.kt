import kotlin.math.abs

fun main(){
    Task6_1_5().start()
}
class Task6_1_5 : BaseTask(){

    fun start(){
        scanner = getFileScanner()
        val n = scanner.nextInt()
        val golds = mutableListOf<Int>()
        for(i in 0 until n){
            golds.add(scanner.nextInt())
        }
        golds.sortDescending()
        println(golds)
        var first = 0
        var second = 0
        for(i in golds){
            if(first>second){
                first -=second
                second = 0
                second+=i
            }
            else{
                second-= first
                first = 0
                first+=i
            }
        }
        println(abs(first - second))
    }
}