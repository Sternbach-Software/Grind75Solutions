fun main() {
    val list1 = SolutionMergeSortedLists.ListNode(1)
    list1.next = SolutionMergeSortedLists.ListNode(2)
    list1.next!!.next = SolutionMergeSortedLists.ListNode(4)
    val list2 = SolutionMergeSortedLists.ListNode(1)
    list1.next = SolutionMergeSortedLists.ListNode(3)
    list1.next!!.next = SolutionMergeSortedLists.ListNode(4)
    println(SolutionMergeSortedLists().mergeTwoLists(list1, list2))
    SolutionValidParentheses().isValid("(){}{[]}")
}