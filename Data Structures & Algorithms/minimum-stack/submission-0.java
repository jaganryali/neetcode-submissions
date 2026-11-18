class MinStack {

    List<Integer> stackData;
    int currPos = -1;
    int minElement = Integer.MAX_VALUE;
    public MinStack() {
        stackData = new ArrayList<>();
    }

    public void push(int val) {
        ++currPos;
        stackData.add(val);
    }

    public void pop() {
        stackData.remove(currPos);
        --currPos;
    }

    public int top() {
        return stackData.get(currPos);
    }

    public int getMin() {
        int min = Integer.MAX_VALUE;
        for(Integer k : stackData){
            if(min > k) min = k;
        }
        return min;
    }
}
