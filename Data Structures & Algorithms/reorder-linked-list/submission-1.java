/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {

        ListNode node = head;
        ListNode fast = node;
        ListNode slow = node;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while(curr != null){
            ListNode tmp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = tmp;
        }

        ListNode first = head;
        ListNode sec = prev;

        while(sec != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = sec.next;
            
            first.next = sec;
            sec.next = tmp1;

            first = tmp1;
            sec = tmp2;
        }





        
    }
}
