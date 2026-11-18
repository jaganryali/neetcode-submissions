class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        int[] ans = new int[nums.length];
        
        left[0]=1;
        right[nums.length-1]=1;

        for(int i = 1; i < nums.length; i++){
            left[i] = left[i-1]*nums[i-1];
            int k = nums.length -1 -i;
            right[k] = right[k+1]*nums[k+1];
        }
        
        for(int i = 0; i < nums.length; i++){
            ans[i] = left[i]*right[i];
        }
        return ans;
        
    }
}  
