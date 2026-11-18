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

        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null && fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode l1 = head;
        ListNode l2 = slow.next;
        slow.next = null;

        l2 = reverse(l2);

        ListNode dummy = new ListNode(-1);
        ListNode out = dummy;


        while(l1 != null || l2 != null){

            if(l1 != null) {
                out.next = l1;
                out = out.next;
                l1 = l1.next;
            }

            if(l2 != null) {
                out.next = l2;
                out = out.next;
                l2 = l2.next;
            }
        }

        head = dummy.next;
    }

    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }
}
