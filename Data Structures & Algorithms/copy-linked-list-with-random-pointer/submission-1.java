
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

        Node node = head;
        Map<Node, Node> map = new HashMap<>();
        while(node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;

        while(node != null) {
            Node clone = map.get(node);
            clone.random = map.get(node.random);
            clone.next = map.get(node.next);
            node = node.next;
        }
        return map.get(head);
        
    }
}
