import java.util.PriorityQueue
//Задача о расписании. У программиста есть n заказов.
fun main() {
    val t = Task3_7_3()
    t.start()
}

class Task3_7_3 : BaseTask() {

    fun start() {
        val n = scanner.nextInt()
        val tasks = MutableList<MutableList<Task>>(n + 1) {
            mutableListOf()
        }
        for (i in 0 until n) {
            val deadline = scanner.nextInt()
            val cost = scanner.nextInt()
            tasks[deadline].add(
                Task(
                    deadline, cost
                )
            )
        }
        var sum = 0L
        //Берём задачу с наибольшей стоимостью/штрафом
        val queue = PriorityQueue<Task> { o1, o2 -> o2.cost - o1.cost }
        for (i in n downTo 1) {
            queue.addAll(tasks[i])
            if(queue.isNotEmpty()) {
                val task = queue.poll()
//                println("Step : $i task :$task")
                sum += task.cost
            }
        }
        //добавление в кучу будет максимум nlogn
        println(sum)

    }

    data class Task(
        var deadline: Int = 0,
        var cost: Int = 0
    )
}