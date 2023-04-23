/**

 * Example:

 * var li = ListNode(5)

 * var v = li.`val`

 * Definition for singly-linked list.

 * class ListNode(var `val`: Int) {

 *     var next: ListNode? = null

 * }

 */

class Solution {

    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {

        if(list1 == null) if(list2 == null) /*both null*/ return null else /*only 1*/ return list2 else if(list2 == null) /*only 2*/ return list1

        

        var final: ListNode? = null

        var i = list1

        var j = list2

        while(i != null || j!= null) {

       if(i != null) {

           if(j != null) {

               //both not null

               val iIsLess = i.`val` < j.`val`

 if(final == null) 

               if(iIsLess) {

     final = i 

     final!!.next = j

 } else { 

     final = j 

     final!!.next = i

 } else {

     if(iIsLess) {

         final!!.next = i

         final!!.next!!.next = j

         } else {

         

         final!!.next = j

         final!!.next!!.next = i

         }

     

      final = final!!.next!!.next

     }

              

               } else {

               //only j null

               final!!.next = i

               final = final!!.next

               } 

          

           } else if( j!= null){

               //only i null

               

               final!!.next = j

               final = final!!.next

               } else {

               //both null

               break

               }

       

 i = i?.next

               j = j?.next

            }

        return final

    }

}
