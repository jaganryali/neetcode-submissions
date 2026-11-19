class Solution {
    public String longestCommonPrefix(String[] strs) {

        int i = 0;
        StringBuffer sb = new StringBuffer();
        while(true) {
            if(i >= strs[0].length()){
                return sb.toString();
            }
            Character c = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++){
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            i++;

        }
        
    }
}