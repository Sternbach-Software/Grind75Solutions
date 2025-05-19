import easy.SolutionMergeSortedLists
import easy.SolutionValidParentheses

fun main() {
    val list1 = SingleLinkedListNode(1)
    list1.next = SingleLinkedListNode(2)
    list1.next!!.next = SingleLinkedListNode(4)
    val list2 = SingleLinkedListNode(1)
    list2.next = SingleLinkedListNode(3)
    list2.next!!.next = SingleLinkedListNode(4)
    list2.next!!.next!!.next = SingleLinkedListNode(5)
    println("Final result: " + SolutionMergeSortedLists().mergeTwoLists(list2, null))
    SolutionValidParentheses().isValid("(){}{[]}")
}