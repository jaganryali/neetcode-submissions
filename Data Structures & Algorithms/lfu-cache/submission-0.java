class LFUCache {

    class Node {
        int key, val, freq;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.freq = 1;
        }
    }
    class DLList {
        Node head, tail;
        int size;
        DLList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;
        }
        void add(Node node) {
            Node lastNode = tail.prev;
            lastNode.next = node;
            node.prev = lastNode;
            node.next = tail;
            tail.prev = node;
            size++;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }

        Node removeLRU() {
            if(size == 0) return null;
            Node rem = head.next;
            remove(rem);
            return rem;
        }
    }

    private int capacity, minFreq;
    private Map<Integer, Node> cache;
    private Map<Integer, DLList> freqMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
        
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        updateFreq(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;
        
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            cache.put(key, node);
            updateFreq(node);
        } else {
            // Create a node
            // Insert to cache
            // Insert to LLIst
            if(cache.size() == capacity) {
                DLList minList = freqMap.get(minFreq);
                Node nodeToRemove = minList.removeLRU();
                cache.remove(nodeToRemove.key);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            minFreq = 1;
            DLList newList = freqMap.getOrDefault(minFreq, new DLList());
            newList.add(newNode);
            freqMap.put(1, newList);
        }
    }

    private void updateFreq(Node node) {
        int oldFreq = node.freq;
        DLList oldList = freqMap.get(oldFreq);
        oldList.remove(node);
        if(oldFreq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        node.freq++;
        DLList newList = freqMap.getOrDefault(node.freq, new DLList());
        newList.add(node);
        freqMap.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */