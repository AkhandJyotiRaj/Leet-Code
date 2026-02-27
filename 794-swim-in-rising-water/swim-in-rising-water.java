class Solution {
    class Tuple{
        int row;
        int col;
        int time;
        Tuple(int row, int col, int time){
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }
    int[] dr = {-1, 1, 0 , 0};
    int[] dc = {0, 0, -1, 1};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        PriorityQueue<Tuple> pq  = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
        pq.add(new Tuple(0, 0, grid[0][0]));
        vis[0][0] = true;
        int max = grid[0][0];
        while(pq.size()>0){
            Tuple curr = pq.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;
            max = Math.max(max , t);
            if( r == n-1 && c == n-1) return max;
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc]){
                    vis[nr][nc] = true;         
                    pq.add(new Tuple(nr, nc, grid[nr][nc]));
                }
            }         
        }
        return max;     
    }
}