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

        Node tmp = head;
        HashMap<Node, Node> map = new HashMap<>();

        while(tmp != null) {
            map.put(tmp, new Node(tmp.val));
            tmp = tmp.next;
        }

        tmp = head;

        while(tmp != null){
            Node newNode = map.get(tmp);
            newNode.next = map.get(tmp.next);
            newNode.random = map.get(tmp.random);

            tmp = tmp.next;
        }

        return map.get(head);
        
    }
}
