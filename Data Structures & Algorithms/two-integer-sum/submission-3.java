class Solution {
    public int[] twoSum(int[] nums, int target) {

        int[] result = new int[2];


        Map<Long, Integer> map = new HashMap<Long, Integer>();

        for( int i = nums.length-1; i >= 0; i--){
            map.put((long)nums[i], i);
        }


        for(int i =0; i< nums.length; i++){
            Long compareKey = (long)(target - nums[i]);
            if(map.containsKey(compareKey) && map.get(compareKey) != i){
                result[0] = i;
                result[1] = map.get((long)(compareKey)); 

                swap(result);
                break;
            }
        }
        return result;
    }

    public int[] swap(int[] ary){
        
        if(ary[0] > ary[1]){
            int k = ary[0];
            ary[0] = ary[1];
            ary[1] = k;
        }
        return ary;
    }

}
