fun main() {
    val t = Task2_10_3()
    t.start()
}

class Task2_10_3 {

    fun start() {
        val n = 10
        getNextHooks(
            0,
            0,
            MutableList(n*2) {
                ' '
            },
            1
        )
    }

    fun getNextHooks(
        position: Int,
        openedHooks: Int,
        currentHooks: MutableList<Char>,
        count: Int
    ): Int {
        if (openedHooks > currentHooks.size - position ) return count
        if (position == currentHooks.size) {
            println(currentHooks + " count: $count")
            return  count + 1
        }
        currentHooks[position] = '('
        var c = count
        c = getNextHooks(position + 1, openedHooks + 1, currentHooks, c)
        if (openedHooks > 0) {
            currentHooks[position] = ')'
            c = getNextHooks(position + 1, openedHooks - 1, currentHooks, c)
        }
        return c
    }
}