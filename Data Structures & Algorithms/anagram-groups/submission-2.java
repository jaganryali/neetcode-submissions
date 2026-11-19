class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            char[] chary = str.toCharArray();
            Arrays.sort(chary);
            String sorted = new String(chary);
            if(map.containsKey(sorted)){
                map.get(sorted).add(str);
                //map.put(sorted, map.get(sorted).add(str));
            }
            else {
                List<String> li = new ArrayList<>();
                li.add(str);
                map.put(sorted, li);
            }
        }

        return new ArrayList(map.values());

    }
}
