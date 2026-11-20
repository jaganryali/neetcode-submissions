class Solution {
    public int majorityElement(int[] nums) {

        Arrays.sort(nums);

        int[] curr = new int[2];
        int[] max = new int[2];
        curr[0] = nums[0];
        curr[1] = 1;

        max[1] = -1;
        for(int i = 1; i < nums.length; i++){
            if( curr[0]== nums[i]){
                ++curr[1];
            }else {
                if(curr[1] > max[1]){
                    max[0] = curr[0];
                    max[1] = curr[1];
                }
                curr[0] = nums[i];
                curr[1] = 1;
            }
        }

        if(curr[1] > max[1]){
                    max[0] = curr[0];
                    max[1] = curr[1];
                }

        return max[0];
        
    }
}