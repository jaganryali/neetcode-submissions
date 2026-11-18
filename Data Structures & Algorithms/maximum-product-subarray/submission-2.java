class Solution {
    public int maxProduct(int[] nums) {

        int lSum = 1;
        int rSum = 1;
        int res = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            lSum = (lSum == 0 ? 1 : lSum) * (nums[i]  ) ;
            rSum = (rSum == 0 ? 1 : rSum) * (nums[nums.length - i -1] );
            res = Math.max(res, Math.max(lSum, rSum));
        }

        return res;
        
    }
}
