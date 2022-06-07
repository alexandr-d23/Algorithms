fun main() {
    Task3_8_4().start()
}

class Task3_8_4 : BaseTask() {

    fun start() {
        scanner = getFileScanner()
        val n = scanner.nextInt()
        var w = scanner.nextInt()
        val items = mutableListOf<Item>()
        for (i in 0 until n) {
            items.add(
                Item(
                    scanner.nextInt(),
                    scanner.nextInt()
                )
            )
        }
        items.sortByDescending { it.costPerW }
        var cost = 0L
        for (item in items) {
            if (item.w < w) {
                cost += item.cost
                w -= item.w
            } else {
                cost += w*item.costPerW
                break
            }
        }
        println(cost)

    }

    data class Item(
        val w: Int,
        val cost: Int,
        val costPerW: Int = cost / w
    )
}