class Solution {
    public int[] getConcatenation(int[] nums) {

        int n = nums.length;

        int[] ary = new int[nums.length*2];

        for(int i = 0; i < n; i++) {
            ary[i] = nums[i];
            ary[i + n] = nums[i];
        }

        return ary;
        
    }
}