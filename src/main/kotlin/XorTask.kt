fun main(){
    XorTask().start()
}

class XorTask : BaseTask() {
    fun start(){
        val n = scanner.nextInt()
        var digit = 0
        for(i in 0 until n){
            digit = digit xor scanner.nextInt()
        }
        println(digit)
    }
}