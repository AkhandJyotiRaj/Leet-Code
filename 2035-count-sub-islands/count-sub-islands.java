class Solution {
    int[] r = {0,-1,0,1};
    int[] c = {-1,0,1,0};
    int n;
    int m;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n = grid2.length;
        m = grid2[0].length;
        int[][] vis = new int[n][m];
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(grid2[i][j] == 1 && vis[i][j] == 0 && isvalid(i,j,grid2,grid1,vis)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
    public boolean isvalid(int cr, int cc, int[][] grid2, int[][] grid1, int[][] vis){
        vis[cr][cc] = 1;
        boolean ans = true;
        if(grid1[cr][cc] == 0){
            ans = false;
        }
        for(int i = 0; i<4; i++){
            int r1 = cr+r[i];
            int c1 = cc+c[i];
            if(r1 >= 0 && r1 < n && c1 >= 0 && c1 < m && vis[r1][c1] == 0 && grid2[r1][c1] == 1){
                ans = ans & isvalid(r1,c1,grid2,grid1,vis);
            }
        }
        return ans;
    }
}