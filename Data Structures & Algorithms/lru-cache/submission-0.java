class LRUCache {
    HashMap<Integer, Node> map= new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }


    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }

        if(map.size() == cap){
            remove(tail.prev);
        }

        insert(new Node(key, value));
    }
    void insert(Node node){
        map.put(node.key, node);
        node.next = head.next;
        node.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    void remove(Node n){
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev = n.prev;

    }
}

class Node {
    Node prev, next;
    int key, value;
    Node(int _key, int _value) {
        key = _key;
        value = _value;
    }
}
