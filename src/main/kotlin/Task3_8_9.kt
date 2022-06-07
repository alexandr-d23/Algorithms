fun main(){
    Task3_8_9().start()
}

class Task3_8_9 : BaseTask() {
    fun start(){
        scanner = getFileScanner()
        val n = scanner.next().toInt()
        var count = 1
        var manufacturers = hashSetOf<String>()
        for(i in 0 until n){
            val s = scanner.next()
            if(manufacturers.contains(s)){
                count++
                manufacturers = hashSetOf()
            }
            manufacturers.add(s)
        }
        println(count)
    }
}