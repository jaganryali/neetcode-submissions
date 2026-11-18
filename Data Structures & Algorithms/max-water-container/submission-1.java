class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length -1;

        int maxArea = 0;
        int currArea = 1;
        while ((left <= heights.length -1 && right >=0) && left < right){

            currArea = Math.min(heights[left], heights[right]) * (right-left);

            maxArea = Math.max(maxArea, currArea);

            if(heights[left] <= heights[right]){
                ++left;
            }else {
                --right;
            }
        }
        return maxArea;
    }
}
