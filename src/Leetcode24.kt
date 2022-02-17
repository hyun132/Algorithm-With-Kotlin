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
    fun swapPairs(head: ListNode?): ListNode? {
        val dummyNode = ListNode(-1)
        dummyNode.next = head
        
        var prev = dummyNode
        var cur = head
        
        while(cur!=null && cur.next!=null){
            val temp = prev.next
            prev.next = cur.next
            cur.next = cur.next.next
            prev.next.next = temp
            
            prev=temp
            cur=prev.next
        }
        return dummyNode.next
    }
}
