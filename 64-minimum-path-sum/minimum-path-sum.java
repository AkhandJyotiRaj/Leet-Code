class Solution {
    public int possibleWays(int[][] grid, int x, int y, Integer[][]dp){
        // Base Case
        if(x==grid.length-1 && y==grid[0].length-1){ // Destination
            return grid[x][y]; // itself is the min
        }else if(x>=grid.length || y>=grid[0].length){ // Moving beyond destination
            return Integer.MAX_VALUE; // invalid
        }

        if(dp[x][y]!=null){
            return dp[x][y];
        }

        
        // Moving Right
        int right = possibleWays(grid, x, y+1, dp);
        // Moving Down
        int down =  possibleWays(grid, x+1, y, dp);

        return dp[x][y] = grid[x][y] + Math.min(right, down); // take best 
    }
    public int minPathSum(int[][] grid) {
        Integer[][] dp = new Integer[grid.length][grid[0].length];
        return possibleWays(grid, 0, 0, dp);
    }
}