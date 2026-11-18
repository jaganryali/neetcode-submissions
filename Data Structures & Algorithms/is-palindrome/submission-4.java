class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;

        int right = s.length()-1;

        if(s.isEmpty()) return true;

        for(int i = 0; i < s.length()/2; i++){

            while(left <= s.length()-1 && !isAlphaNumeric(s.charAt(left))){
                ++left;
            }

            while(right >= 0 && !isAlphaNumeric(s.charAt(right))){
                --right;
            }

             if(left <= s.length()-1 && right >= 0 && Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) return false;
            ++left;
            --right;

        }

        return true;
    }

    private boolean isAlphaNumeric(char c){
        if( (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) return true;
        return false;
    }
}
