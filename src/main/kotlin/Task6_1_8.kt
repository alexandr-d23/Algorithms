fun main(){
    Task6_1_8().start()
}

class Task6_1_8: BaseTask() {

    fun start(){
        scanner = getFileScanner()
        val n = scanner.nextInt()
        val list = mutableListOf<Int>()
        for( i in 0 until n){
            list.add(scanner.nextInt())
        }
        list.sort()
        var sum = 0L
        for(i in 0 until n/2){
            sum+=list[i]
        }
        for(i in n/2 until n){
            sum-=list[i]
        }
        println(sum)
    }
}