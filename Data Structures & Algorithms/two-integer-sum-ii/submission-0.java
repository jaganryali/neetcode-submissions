class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length -1;
        while ((left <= numbers.length -1 && right >= 0) && left < right){

            int k = numbers[left] + numbers[right];
            if(k == target) return new int[]{++left, ++right};
            if( k > target){
                -- right;
            }else {
                ++left;
            }
        }
        return new int[]{left, right};
        
    }
}
