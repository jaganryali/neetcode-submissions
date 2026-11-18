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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode out = new ListNode(-1);
        ListNode result = out;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                result.next = list1;
                result = result.next;
                list1 = list1.next;
            } else {
                result.next = list2;
                result = result.next;
                list2 = list2.next;
            }
        }

        if(list1 != null) {
            result.next = list1;
        }

        if(list2 != null) {
            result.next = list2;
        }

        return out.next;
        
    }
}