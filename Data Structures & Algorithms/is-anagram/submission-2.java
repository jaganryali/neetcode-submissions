class Solution {
    public boolean isAnagram(String s, String t) {

        int[] ary = new int[26];

        if(s.length() != t.length()) return false;

        for(int i = 0; i < ary.length; i++){
            ary[i] = 0;
        }

        for(int i = 0; i < s.length(); i++){
           
            ++ary[s.charAt(i) - 'a'];
        }

        for(int i = 0; i < t.length(); i++){
              --ary[t.charAt(i) - 'a'];
        }


        for(int i = 0; i < ary.length; i++){
            if(ary[i] != 0) return false;
        }

        return true;


    }
}
