class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer, Integer> map = new LinkedHashMap<>();

        for(int i =0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                Integer val = map.get(nums[i]);
                map.put(nums[i], ++val);
            }else {
                map.put(nums[i], 1);
            }
        }

        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>( (e1, e2) -> e2.getValue().compareTo(e1.getValue()));

        queue.addAll(map.entrySet());
        int[] res = new int[k];

        for(int i =0; i < k; i ++){
            if(!queue.isEmpty()) {
                res[i] = queue.poll().getKey();
            }
        }

        return res;
    }
}
