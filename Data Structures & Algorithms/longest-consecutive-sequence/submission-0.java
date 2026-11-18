class Solution {
    public int longestConsecutive(int[] nums) {

        Arrays.sort(nums);        
        int max = 1;
        int total = 1;
        if(nums.length == 0) return 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] - nums[i-1] == 1){
                total = total+1;
            } else if (nums[i] == nums[i-1]){
                // Do nothing
            }
            else {
            if(total > max) max = total;
            total = 1;
            }
        }
        return total > max ? total : max;  
        
    }
}
