package easy

import java.util.Stack

class QueueUsingStacks {
}
class MyQueue() {

    private val stackIn = Stack<Int>()
    private val stackOut = Stack<Int>()

    private fun transferStackInToOut() {
        if (stackOut.isEmpty()) {
            while (stackIn.isNotEmpty()) {
                stackOut.push(stackIn.pop())
            }
        }
    }

    fun push(x: Int) {
        stackIn.push(x)
    }

    fun pop(): Int {
        transferStackInToOut() // Only transfer if stackOut is empty
        return stackOut.pop()
    }

    fun peek(): Int {
        transferStackInToOut() // Only transfer if stackOut is empty
        return stackOut.peek()
    }

    fun empty(): Boolean {
        return stackIn.empty() && stackOut.empty()
    }

}