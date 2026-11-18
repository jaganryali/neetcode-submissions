class MyCircularQueue {
    int[] ary = null;
    int currSize = 0;
    int head;
    int tail;
    int k;

    public MyCircularQueue(int k) {
        ary = new int[k];
        this.k = k;
        head = 0;
        tail = -1;
        this.currSize = 0;
    }
    
    public boolean enQueue(int value) {
        if(!isFull()) {
            tail = (tail + 1) % k;
            ary[tail] = value;
            ++currSize;
            return true;
        }else {
            return false;
        }
    }
    
    public boolean deQueue() {
        if(!isEmpty()){
            head = (head + 1)%k;
            --currSize;
            return true;
        }else 
            return false;
    }
    
    public int Front() {
        if(!isEmpty())
            return ary[head];
        else
            return -1;
    }
    
    public int Rear() {
        if(!isEmpty())
            return ary[tail];
        else return -1;
    }
    
    public boolean isEmpty() {
        return currSize == 0;
    }
    
    public boolean isFull() {
        return currSize == k;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */