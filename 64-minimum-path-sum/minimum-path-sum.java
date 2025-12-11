// class Solution {
//     public int possibleWays(int[][] grid, int x, int y, Integer[][]dp){
//         // Base Case
//         if(x==grid.length-1 && y==grid[0].length-1){ // Destination
//             return grid[x][y]; // itself is the min
//         }else if(x>=grid.length || y>=grid[0].length){ // Moving beyond destination
//             return Integer.MAX_VALUE; // invalid
//         }

//         if(dp[x][y]!=null){
//             return dp[x][y];
//         }

        
//         // Moving Right
//         int right = possibleWays(grid, x, y+1, dp);
//         // Moving Down
//         int down =  possibleWays(grid, x+1, y, dp);

//         return dp[x][y] = grid[x][y] + Math.min(right, down); // take best 
//     }
//     public int minPathSum(int[][] grid) {
//         Integer[][] dp = new Integer[grid.length][grid[0].length];
//         return possibleWays(grid, 0, 0, dp);
//     }
// }


class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for (int k = 0; k < m; k++) {
            Arrays.fill(dp[k], -1);
        }

        return minPathSum1(grid, m - 1 , n - 1, dp);
    }

    public int minPathSum1(int[][] grid, int m, int n, int[][] dp) {
        if(m == 0 && n == 0) {
            return grid[0][0];
        } 
        if(m < 0 || n < 0) {
            return Integer.MAX_VALUE;
        } 

        if(dp[m][n] != -1) {
            return dp[m][n];
        }

        int up = minPathSum1(grid, m-1, n, dp);
        int left = minPathSum1(grid, m, n-1, dp);

        return dp[m][n] = grid[m][n] + Math.min(up, left);
    }
}
