package medium

import ListNode

class Calculator {
    fun calculate(s: String): Int {
        val numbers = hashSetOf('1', '2', '3', '4', '5', '6', '7', '8', '9', '0')
        val operators = hashSetOf('+', '-', '/', '*')

        val multiplicationQueue = ArrayDeque<ListNode<String>>()
        val divisionQueue = ArrayDeque<ListNode<String>>()
        val additionQueue = ArrayDeque<ListNode<String>>()
        val subtractionQueue = ArrayDeque<ListNode<String>>()
        var head: ListNode<String>? = null
        var currentTail: ListNode<String>? = null
        var currentNum: String? = null

        for (char in s) {
            println("Iterating $char")
            if (char in numbers) {
                if (currentNum == null) {
                    currentNum = char.toString()
                    continue
                } else currentNum += char
                println("Current num: $currentNum")
            } else if (char in operators) {
                //add currentNum and operator, and reset char run

                val operator = ListNode(char.toString())
                println("Operator: $char, Current num: $currentNum")
                if (head == null) {
                    //currentTail is also null
                    head = ListNode(currentNum!!)
                    currentTail = operator
                    head?.next = currentTail
                    currentTail?.prev = head
                } else {
                    val prev = currentTail
                    currentTail = ListNode(currentNum!!)
                    prev?.next = currentTail
                    currentTail?.prev = prev
                }
                currentNum = null

                //add operator

                when (char) {
                    '+' -> additionQueue.addFirst(operator)
                    '-' -> subtractionQueue.addFirst(operator)
                    '*' -> multiplicationQueue.addFirst(operator)
                    '/' -> divisionQueue.addFirst(operator)
                }
            }
        }
        //add last num
        val prev = currentTail
        currentTail = ListNode(currentNum!!)
        prev?.next = currentTail
        currentTail?.prev = prev

        //MDAS
        var node: ListNode<String>? = null
        for (queue in listOf(
            multiplicationQueue,
            divisionQueue,
            additionQueue,
            subtractionQueue
        )) while (queue.isNotEmpty()) {
            val operator = queue.removeLast()
            val char = operator.value[0]

            val left = operator.prev
            val right = operator.next
            val leftNum = left?.value?.toInt()
            val rightNum = right?.value?.toInt()
            if (leftNum == null || rightNum == null) continue
            val answer = when (char) {
                '+' -> leftNum + rightNum
                '-' -> leftNum - rightNum
                '*' -> leftNum * rightNum
                '/' -> (leftNum / rightNum).toInt()
                else -> 0
            }
            println("$leftNum $char $rightNum = $answer")

            node = ListNode(answer.toString())
            val newLeft = left?.prev
            val newRight = right?.next
            newLeft?.next = node
            newRight?.prev = node
            node.prev = newLeft
            node.next = newRight
            println(node.getHead().getHeadString())
        }
        return node?.value?.toInt() ?: 0
    }

    fun calculateOnePass(s: String?): Int {
        if (s.isNullOrEmpty()) return 0
        var lastNumber = 0
        var currentNumber = 0
        var result = 0
        var operation = '+'
        for ((index, char) in s.withIndex()) {
            if (char.isDigit()) {
                currentNumber = (currentNumber * 10) + (char.code - '0'.code)
            }
            if (!char.isDigit() && !char.isWhitespace() || index == s.lastIndex) {
                when (operation) {
                    '+', '-' -> {
                        result += lastNumber
                        lastNumber = if (operation == '+') currentNumber else -currentNumber
                    }
                    '*' -> {
                        lastNumber *= currentNumber
                    }
                    '/' -> {
                        lastNumber /= currentNumber
                    }
                }
                operation = char
                currentNumber = 0
            }
        }
        result += lastNumber
        return result
    }


    companion object {
        @JvmStatic
        fun main(array: Array<String>) {
            println(Calculator().calculateOnePass("3+2*2") == 7)
            println(Calculator().calculateOnePass(" 3/2 ") == 1)
            println(Calculator().calculateOnePass(" 3/2*2 ") == 2)

        }
    }
}