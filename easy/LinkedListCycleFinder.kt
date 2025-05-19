package easy

import SingleLinkedListNode

class LinkedListCycleFinder {
    /***
     * Known as Floy's cycle finding algorithm. If [fast] catches up to [slow], there is a cycle.
     * Space: O(1)
     * Time: O(N)
     * */
    fun hasCycle(head: SingleLinkedListNode?): Boolean {
        var slow: SingleLinkedListNode? = head
        var fast: SingleLinkedListNode? = head?.next

        while (fast?.next != null) {
            if (slow == fast) {
                return true
            }
            slow = slow?.next
            fast = fast.next?.next
        }

        return false
    }
}