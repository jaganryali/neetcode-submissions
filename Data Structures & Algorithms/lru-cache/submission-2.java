class LRUCache {

    class Node {
        int key, val;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

        private Map<Integer, Node> map;
        private int capacity;
        private Node head, tail; // Dummy nodes



    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {

        if(map.containsKey(key))
            remove(map.get(key));

        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);

        if(map.size() > capacity) {
            Node nodeToRemove = head.next;
            remove(nodeToRemove);
            map.remove(nodeToRemove.key);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node) {
        Node lastNode = tail.prev;

        lastNode.next = node;
        node.prev = lastNode;
        node.next = tail;
        tail.prev = node;
    }
}
