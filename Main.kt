fun main() {
    val list1 = SolutionMergeSortedLists.ListNode(1)
    list1.next = SolutionMergeSortedLists.ListNode(2)
    list1.next!!.next = SolutionMergeSortedLists.ListNode(4)
    val list2 = SolutionMergeSortedLists.ListNode(1)
    list2.next = SolutionMergeSortedLists.ListNode(3)
    list2.next!!.next = SolutionMergeSortedLists.ListNode(4)
    list2.next!!.next!!.next = SolutionMergeSortedLists.ListNode(5)
    println("Final result: " + SolutionMergeSortedLists().mergeTwoLists(list2, null))
    SolutionValidParentheses().isValid("(){}{[]}")
}