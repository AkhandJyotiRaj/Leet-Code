class Solution {

    class Pair{
        int row,col,effort;

        public Pair(int r,int c,int e){
            row = r;
            col = c;
            effort = e;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];

        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.effort - b.effort);
        pq.add(new Pair(0,0,0));
        dist[0][0] = 0;

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while(!pq.isEmpty()){
            
            Pair curr = pq.poll();

            int r = curr.row;
            int c = curr.col;
            int effort = curr.effort;

            if(r == m - 1 && c == n - 1){
                return effort;
            }

            for(int i = 0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr >= 0 && nc>=0 && nr<m && nc<n){
                    int newEffort = Math.max(
                        effort,
                        Math.abs(heights[r][c] - heights[nr][nc])
                    );

                    if(newEffort < dist[nr][nc]){
                        dist[nr][nc] = newEffort;
                        pq.add(new Pair(nr,nc,newEffort));
                    }
                }
            }
        }
         return 0;
    }
}