// class Solution {
//     public int uniquePaths(int m, int n) {
        
//         if(m == 1 && n == 1) return 1;
//         if(m ==0 || n == 0) return 0;


//         return uniquePaths(m,n-1) + uniquePaths(m-1,n);
//     }
// }

// class Solution {
//     public int uniquePaths(int m, int n) {        //dp
//         int[][] dp = new int[m][n];
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 dp[i][j] = -1;
//             }
//         }
//         return countPaths(0, 0, m, n, dp);
//     }

//     private int countPaths(int row, int col, int m, int n, int[][] dp) {
//         if (row == m - 1 && col == n - 1) return 1;
//         if (row >= m || col >= n) return 0;

//         if (dp[row][col] != -1) {
//             return dp[row][col];
//         }

//         int down = countPaths(row + 1, col, m, n, dp);
//         int right = countPaths(row, col + 1, m, n, dp);

//         return dp[row][col] = down + right;
//     }
// }

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            dp[i][0]=1;
            for(int j=0;j<n;j++){
                dp[0][j]=1;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1; j<n; j++){
                dp[i][j]=dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

    }
}