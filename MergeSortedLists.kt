/**

 * Example:

 * var li = ListNode(5)

 * var v = li.`val`

 * Definition for singly-linked list.

 * class ListNode(var `val`: Int) {

 *     var next: ListNode? = null

 * }

 */

class SolutionMergeSortedLists {
    class ListNode(
        var `val`: Int,
        var next: ListNode? = null
    ) {
        override fun toString(): String {
            return "ListNode(val = $`val`, next = $next)"
        }
    }

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        println("mergeTwoLists(list1 = $list1, list2 = $list2)")
        /*if (list1 == null)
            return list2
        else if (list2 == null) *//*only 2*//* return list1
        var final: ListNode? = ListNode(0)
        var next: ListNode? = null
        final?.next = next
        var i = list1
        var j = list2
        while (i != null || j != null) {
            println("Loop: \ni = $i, \nj = $j, \nfinal = $final")
            if (i != null) {
                if (j != null) {
                    //both not null
                    val node =
                        if (i.`val` < j.`val`) ListNode(i.`val`, j)
                        else ListNode(j.`val`, i)

                    if (next == null)
                        next = node
                    else
                        next.next = node
                } else {
                    //only j null
                    if (next == null) next = i
                    else next.next = i
                }
            } else { *//*j cannot be null because then they would both be null, and the loop wouldn't have ran*//*
                //only i null
                if (next == null) next = j
                else next.next = j
            }
            println("Before reset:")
            println("final: $final")
            println("i: $i")
            println("j: $j")

            next = next?.next
            i = i?.next
            j = j?.next
        }
        return final*/
        val result = ListNode(0)
        var current = result

        var node1 = list1
        var node2 = list2
        while (node1 != null || node2 != null) {
            if (node1 == null) {
                current.next = node2
                break
            }
            if (node2 == null) {
                current.next = node1
                break
            }

            if (node1.`val` < node2.`val`) {
                current.next = node1
                node1 = node1.next
            } else {
                current.next = node2
                node2 = node2.next
            }
            current = current.next!!/*compiler can't yet determine nullability of/smart cast 'complex expressions'*/
        }
        return result.next
    }
}
