class Solution {
    private static final int[][] directions = {{1,0}, {0, 1}, {-1,0},{0,-1}};
    private static int INF = 2147483647;
    private boolean[][] visits = null;
    public void islandsAndTreasure(int[][] grid) {

        visits = new boolean[grid.length][grid[0].length];

        for(int r = 0; r < grid.length; r++){
            for(int c = 0; c < grid[0].length; c++) {
                if(grid[r][c] == INF){
                    grid[r][c] = bfs(grid, r, c);
                    
                } 
            }
        }        
    }

    public int bfs(int[][] grid, int r, int c) {
        
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visits = new boolean[grid.length][grid[0].length];
        q.add(new int[]{r,c});
        int steps = 0;
        visits[r][c] = true;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size; i++){
                int[] cc = q.poll();
                if(grid[cc[0]][cc[1]] ==0) return steps;

                for(int[] dir : directions) {
                    int nr = dir[0] + cc[0];
                    int nc = dir[1] + cc[1];
                    if(nr >= 0 && nr < grid.length && nc >=0 && nc < grid[0].length && grid[nr][nc] != -1 && !visits[nr][nc]) {
                        visits[nr][nc] = true;
                        q.add(new int[] {nr, nc});
                    }
                } 
            }
            ++steps;
        }
        return INF;
    }
}
