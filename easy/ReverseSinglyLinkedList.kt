package easy

class ReverseSinglyLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        val stack = ArrayDeque<ListNode>()
        var next = head
        while(next != null) {
            stack.addFirst(next)
            next = next.next
        }
        for((index, item) in stack.withIndex()) item.next = stack.getOrNull(index + 1)
        return stack.firstOrNull()
    }
}