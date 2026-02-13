class Solution {

    class Pair{
        int row;
        int col;
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;
        
        int[][] dist = new int[n][m];
        Queue<Pair> q = new LinkedList<>();

        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(mat[i][j]==0){
                    dist[i][j] = 0;
                    q.offer(new Pair(i,j));
                }
                else {dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};

        while(!q.isEmpty()){
            Pair cur = q.poll();

            for(int i=0;i<4;i++){
                int nr = cur.row +drow[i];
                int nc = cur.col+ dcol[i];

                if(nr>=0 && nc>= 0 && nr<n && nc<m){
                    if(dist[nr][nc]> dist[cur.row][cur.col]+1){
                        dist[nr][nc] = dist[cur.row][cur.col]+1;
                        q.offer(new Pair(nr,nc));
                    }
                }
            }
        }
        return dist;

        
    }
}