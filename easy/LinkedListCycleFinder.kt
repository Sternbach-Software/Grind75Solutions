package easy

class LinkedListCycleFinder {
    /***
     * Known as Floy's cycle finding algorithm. If [fast] catches up to [slow], there is a cycle.
     * Space: O(1)
     * Time: O(N)
     * */
    fun hasCycle(head: ListNode?): Boolean {
        var slow: ListNode? = head
        var fast: ListNode? = head?.next

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