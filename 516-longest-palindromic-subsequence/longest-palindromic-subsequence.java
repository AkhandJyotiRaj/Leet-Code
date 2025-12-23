class Solution {
    public int longestPalindromeSubseq(String s) {
       String rev = new StringBuilder(s).reverse().toString();
        int m = s.length();
        int n = rev.length();
        
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(s, rev, m, n, dp);
    }

    public static int solve(String s, String rev, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        
        // already calculated
        if (dp[m][n] != -1) return dp[m][n];
        
        if (s.charAt(m - 1) == rev.charAt(n - 1)) {
            dp[m][n] = 1 + solve(s, rev, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(
                solve(s, rev, m - 1, n, dp),
                solve(s, rev, m, n - 1, dp)
            );
        }
        
        return dp[m][n];
        
    }
}