class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int maxarea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(i, j, grid);
                    maxarea = Math.max(maxarea, area);
                }
            }
        }
        return maxarea;
    }
    public int dfs(int i , int j , int[][] grid){
        if(i<0 || i>=grid.length || j<0 || j>= grid[0].length || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] =0;
        int area = 1;
        area+= dfs(i,j+1,grid);
        area+= dfs(i,j-1,grid);
        area+= dfs(i+1,j,grid);
        area+= dfs(i-1,j,grid);
        return area;
    }
}