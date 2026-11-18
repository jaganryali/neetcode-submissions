class Solution {
    private static final int[][] directions = {{1,0}, {0, 1}, {-1,0},{0,-1}};
    public int orangesRotting(int[][] grid) {
        int time = 0;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2){
                    queue.add(new int[]{i, j});
                }
                if(grid[i][j] == 1) {
                    ++fresh;
                }
            }
        }

        while (fresh > 0 && !queue.isEmpty()) {
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];

                for(int[] dir : directions){
                    int rw = r + dir[0];
                    int cw = c + dir[1];

                    if( rw >= 0 && rw < grid.length && cw >=0 && cw < grid[0].length && grid[rw][cw] == 1) {
                        --fresh;
                        grid[rw][cw] = 2;
                        queue.add(new int[] {rw, cw});
                    }
                }
            }
            ++time;
        }
        return fresh == 0 ? time : -1;
        
    }
}
