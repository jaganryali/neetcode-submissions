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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode sum = dummy;
        while (l1 != null && l2 != null){
            int currCount = carry + l1.val + l2.val;
            int val = 0;
            if(currCount > 9){
                val = currCount % 10;
                carry = currCount/10;
            }else {
                val = currCount;
                carry = 0;
            }

            ListNode newNode = new ListNode(val);
            sum.next = newNode;
            sum = sum.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int currCount = l1.val + carry;
            int val = 0;
            if(currCount > 9){
                val = currCount % 10;
                carry = currCount/10;
            }else {
                val = currCount;
                carry = 0;
            }
            ListNode newNode = new ListNode(val);
            sum.next = newNode;
            sum = sum.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int currCount = l2.val + carry;
            int val = 0;
            if(currCount > 9){
                val = currCount % 10;
                carry = currCount/10;
            }else {
                val = currCount;
                carry = 0;
            }
            ListNode newNode = new ListNode(val);
            sum.next = newNode;
            sum = sum.next;
            l2 = l2.next;
        }

        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            sum.next = newNode;
        }

        return dummy.next;
        
    }
}
