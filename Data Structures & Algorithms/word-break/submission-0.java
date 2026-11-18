class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean dp[] = new boolean[s.length() +1];

        HashSet<String> set = new HashSet<>(wordDict);

        int maxLen = Integer.MIN_VALUE;
        for(String str: set){
            maxLen = Math.max(maxLen, str.length());
        }

        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){

            for(int j = i-1; j >= Math.max(0, i-maxLen); j--) {

                if(dp[j] && set.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
