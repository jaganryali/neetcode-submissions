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

        ListNode li1 = list1;
        ListNode li2 = list2;
        ListNode dummy = new ListNode(-1);
        ListNode out = dummy;
        while(li1 != null && li2 != null){
            if(li1.val < li2.val){
                out.next = li1;
                li1 = li1.next;
            } else {
                out.next = li2;
                li2 = li2.next;
            }
            out = out.next;
        }


        if(li1 != null){
            out.next = li1;
        } else {
            out.next = li2;
        }        
        return dummy.next;
    }
}