class Solution {
    public int orangesRotting(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int dir[][] = {
            {-1,0},
            {1,0},
            {0,-1},
            {0,1}
        };

        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int k = 0;k<size;k++){
                int [] curr = q.poll();
                int i = curr[0];
                int j = curr[1];

                for(int d = 0;d<4;d++){
                    int ni = i + dir[d][0];
                    int nj = j + dir[d][1];
                    
                    if(ni>=0 && ni< n && nj>=0 && nj<m && grid[ni][nj] == 1){
                        grid[ni][nj] = 2;
                        fresh--;
                        q.offer(new int[]{ni,nj});
                    }
                }
            }
            time++;
        }






        if(fresh >0){
            return -1;
        }
        return time;

    }
}