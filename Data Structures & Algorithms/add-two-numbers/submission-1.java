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

        ListNode ans = new ListNode(0);
        ListNode result = ans;
        int cry = 0;

        while(l1 != null && l2 != null) {
            int sum = l1.val + l2.val + cry;
            if(sum > 9) {
                cry = sum / 10;
                sum = sum % 10;
                
            } else {
                cry = 0;
            }
            ListNode newNode = new ListNode(sum);
            result.next = newNode;
            result = result.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null) {
            int sum = l1.val + cry;
            if(sum > 9) {
                cry = sum / 10;
                sum = sum%10;    
            } else {
                cry = 0;
            }
            ListNode newNode = new ListNode(sum);
            result.next = newNode;
            result = result.next;
            l1 = l1.next;
        }

        while(l2 != null) {
            int sum = l2.val + cry;
            if(sum > 9) {
                cry = sum / 10;
                sum = sum%10;    
            } else {
                cry = 0;
            }
            ListNode newNode = new ListNode(sum);
            result.next = newNode;
            result = result.next;
            l2 = l2.next;
        }

        if(cry > 0) {
            ListNode newNode = new ListNode(cry);
            result.next = newNode;
        }

        return ans.next;
        
        
    }
}
