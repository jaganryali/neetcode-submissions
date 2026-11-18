class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new LinkedHashMap<>();
        
        for( String str : strs) {
            String sortdStr = sort(str);
            
            if(map.containsKey(sortdStr)){
                List<String> currentList =  map.get(sortdStr);
                currentList.add(str);
                map.put(sortdStr, currentList);
            }else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(sortdStr, newList);
            }
        }
        List<List<String>> response = new ArrayList<>();
        
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            response.add(entry.getValue());
        }
        
        return response;
        
        
    }

    private String sort(String str){
        char[] ary = str.toCharArray();
        Arrays.sort(ary);
        return Arrays.toString(ary);
    }
}
