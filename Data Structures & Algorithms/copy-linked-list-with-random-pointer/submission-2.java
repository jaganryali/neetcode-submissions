
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    public Node copyRandomList(Node head) {

        if(head == null) return null;

        Node curr = head;

        while(curr != null){
            Node tmp = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = tmp;
            curr = tmp;
        }

        curr = head;

        while(curr != null) {
            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node newHead = curr.next;
        Node clone = newHead;

        while(curr != null) {
            curr.next = curr.next.next;
            if(clone.next != null) {
                clone.next = clone.next.next;
            }
            curr = curr.next;
            clone = clone.next;
        }
        return newHead;

    }
    
}
