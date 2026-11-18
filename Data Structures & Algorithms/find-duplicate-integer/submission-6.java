class Solution {
    public int findDuplicate(int[] nums) {

        int idx = nums[0];
        while(true) {
            int tmp = nums[idx];
            if(tmp == -1) {
                return idx;
            }
            nums[idx] = -1;

            idx = tmp;
        }
        
    }
}
