class Solution {
    private static final int[][] directions = {{1,0}, {0, 1}, {-1,0},{0,-1}};
    public int maxAreaOfIsland(int[][] grid) {

        int islands = 0;
        int ans = 0;

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == 1){
                    ans = Math.max(ans, dfs(grid, r, c));
                    ++islands;
                } 
            }
        }

        return ans;        
    }

    public int dfs(int[][] grid, int r, int c) {
        int res = 0;
        if( r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return res;
        }
        res =1;

        grid[r][c] = 0;
        for(int[] dir : directions) {
            res = res + dfs(grid, r + dir[0], c + dir[1]);
        }
        return res;
    }
}
