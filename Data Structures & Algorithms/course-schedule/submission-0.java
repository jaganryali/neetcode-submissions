class Solution {
    private Map<Integer, List<Integer>> preMap = new HashMap<>();

    private Set<Integer> visiting = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for(int i = 0; i < numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] item: prerequisites) {
            preMap.get(item[0]).add(item[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i)){
                return false;
            }
        }

        return true;

    }

    private boolean dfs(int c) {
        if(visiting.contains(c)){
            return false;
        }

        if(preMap.get(c).isEmpty()) {
            return true;
        }
        visiting.add(c);

        for(int item : preMap.get(c)) {
            if(!dfs(item)){
                return false;
            }
        }
        visiting.remove(c);
        preMap.put(c, new ArrayList<>());
        return true;

    }
}
