class Solution {
    public int maxProfit(int[] prices) {

        int maxProf = 0;
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        left[0] = prices[0];
        right[prices.length-1] = prices[prices.length-1];
        for(int i = 1; i < prices.length; i++){
            left[i] = Math.min(left[i-1], prices[i]);
            int k = prices.length-1-i;
            right[k] = Math.max(right[k+1], prices[k]);
            
        }

        for(int i = 0; i < prices.length; i++){
            maxProf = Math.max(maxProf, right[i] -left[i]);
        }
        
        
        return maxProf;
        
    }
}
