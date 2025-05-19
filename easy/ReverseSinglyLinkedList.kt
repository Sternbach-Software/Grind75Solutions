package easy

import SingleLinkedListNode

class ReverseSinglyLinkedList {
    fun reverseList(head: SingleLinkedListNode?): SingleLinkedListNode? {
        val stack = ArrayDeque<SingleLinkedListNode>()
        var next = head
        while(next != null) {
            stack.addFirst(next)
            next = next.next
        }
        for((index, item) in stack.withIndex()) item.next = stack.getOrNull(index + 1)
        return stack.firstOrNull()
    }
}