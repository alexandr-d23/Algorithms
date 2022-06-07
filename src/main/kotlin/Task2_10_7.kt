fun main() {
    val t = Task2_10_7()
    t.start()
}

class Task2_10_7 {

    fun start() {
        val n = 7
        getNextHooks(
            0,
            0,
            MutableList(n * 2) {
                ' '
            },
            1,
            ArrayDeque()
        )
    }

    fun getNextHooks(
        position: Int,
        openedHooks: Int,
        currentHooks: MutableList<Char>,
        count: Int,
        stack: ArrayDeque<Char>
    ): Int {
//        println(currentHooks + " count: $count stask: $stack")
        if (openedHooks > currentHooks.size - position) return count
        if (position == currentHooks.size) {
            if(count == 8233) println(currentHooks + " count: $count")
            return count + 1
        }
        val newStack = ArrayDeque(stack)
        currentHooks[position] = '('
        newStack.addLast('(')
        var c = count
        c = getNextHooks(position + 1, openedHooks + 1, currentHooks, c, newStack)
        newStack.removeLast()
        if (openedHooks > 0 && newStack.isNotEmpty() && newStack.last() == '(') {
            currentHooks[position] = ')'
            newStack.removeLast()
            c = getNextHooks(position + 1, openedHooks - 1, currentHooks, c, newStack)
            newStack.addLast('(')
        }
        currentHooks[position] = '['
        newStack.addLast('[')
        c = getNextHooks(position + 1, openedHooks + 1, currentHooks, c, newStack)
        newStack.removeLast()

        if (openedHooks > 0 && newStack.isNotEmpty() && newStack.last() == '[') {
            currentHooks[position] = ']'
            newStack.removeLast()
            c = getNextHooks(position + 1, openedHooks - 1, currentHooks, c, newStack)
        }

        return c
    }
}