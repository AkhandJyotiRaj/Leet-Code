class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Integer[][] dp = new Integer[m][n]; 
        
        return helper(0, 0, grid, dp);
    }
    
    private int helper(int i, int j, int[][] grid, Integer[][] dp) {
        int m = grid.length;
        int n = grid[0].length;
        
        if (i >= m || j >= n) return Integer.MAX_VALUE;
        
        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }
        
        if (dp[i][j] != null) return dp[i][j];
        
        int right = helper(i, j + 1, grid, dp);
        int down = helper(i + 1, j, grid, dp);
        
        dp[i][j] = grid[i][j] + Math.min(right, down);
        
        return dp[i][j];
    }
}