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
    data class ListNode(
        var `val`: Int,
        var next: ListNode? = null
    )

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        println("mergeTwoLists(list1 = $list1, list2 = $list2)")
        if (list1 == null)
            return list2
        else if (list2 == null) /*only 2*/ return list1
        var final: ListNode? = null
        var i = list1
        var j = list2
        while (i != null || j != null) {
            if (i != null) {
                if (j != null) {
                    //both not null
                    val iIsLess = i.`val` < j.`val`
                    if (final == null)
                        if (iIsLess) {
                            final = i
                            final.next = j
                        } else {
                            final = j
                            final.next = i
                        }
                    else {
                        if (iIsLess) {
                            final.next = i
                            final.next!!.next = j
                        } else {
                            final.next = j
                            final.next!!.next = i
                        }
                        final = final.next!!.next
                    }
                } else {
                    //only j null
                    if(final == null) final = i
                    else final.next = i
                    final = final.next
                }
            } else { /*j cannot be null because then they would both be null, and the loop wouldn't have ran*/
                //only i null
                if(final == null) final = j
                else final.next = j
                final = final!!.next
            }
            i = i?.next
            j = j?.next
        }
        return final
    }
}
