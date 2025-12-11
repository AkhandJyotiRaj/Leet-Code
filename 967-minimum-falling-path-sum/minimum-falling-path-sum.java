class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int dp[][] = new int[n][m];

        for (int col = 0; col < m; col++) {
            dp[0][col] = matrix[0][col];
        }

        for(int i=1; i<n; i++) {
            for(int j=0; j<m; j++) {
                int left = Integer.MAX_VALUE;
                int right = Integer.MAX_VALUE;
                int up = Integer.MAX_VALUE;
                if(j-1 >= 0) left = matrix[i][j] + dp[i-1][j-1];
                up = matrix[i][j] + dp[i-1][j];
                if(j+1 < m) right = matrix[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.min(left, Math.min(up, right));
            }
        }

        for(int i=0; i<m; i++) {
            min = Math.min(min, dp[n-1][i]);
        }
        return min;
    }
}