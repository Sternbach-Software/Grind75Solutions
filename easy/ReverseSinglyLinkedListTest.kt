package easy

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReverseSinglyLinkedListTest {
    @Test
    fun simple() {
        val original = ListNode(
            1,
            ListNode(2,
                ListNode(3,
                    ListNode(4, ListNode(5))
                )
            )
        )
        val reversed = ListNode(5, ListNode(4, ListNode(3, ListNode(2, ListNode(1)))))
        assertEquals(reversed, ReverseSinglyLinkedList().reverseList(original))
    }
}