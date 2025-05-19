package easy

import SingleLinkedListNode
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ReverseSinglyLinkedListTest {
    @Test
    fun simple() {
        val original = SingleLinkedListNode(
            1,
            SingleLinkedListNode(2,
                SingleLinkedListNode(3,
                    SingleLinkedListNode(4, SingleLinkedListNode(5))
                )
            )
        )
        val reversed = SingleLinkedListNode(5, SingleLinkedListNode(4, SingleLinkedListNode(3, SingleLinkedListNode(2, SingleLinkedListNode(1)))))
        assertEquals(reversed, ReverseSinglyLinkedList().reverseList(original))
    }
}