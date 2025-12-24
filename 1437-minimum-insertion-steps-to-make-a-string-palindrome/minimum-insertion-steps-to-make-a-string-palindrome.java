// class Solution {
//     int[][] dp;

//     public int minInsertions(String s) {
//         int n = s.length();
//         dp = new int[n][n];
//         return solve(s, 0, n - 1);
//     }

//     public int solve(String s, int i, int j) {
//         // base cases
//         if (i > j) return 0;
//         if (i == j) return 0;

//         if (dp[i][j] != 0) return dp[i][j];

//         if (s.charAt(i) == s.charAt(j)) {
//             dp[i][j] = solve(s, i + 1, j - 1);
//         } else {
//             dp[i][j] = Math.min(
//                1 + solve(s, i + 1, j),
//                1 + solve(s, i, j - 1)
//             );
//         }
//         return dp[i][j];
//     }
// }

class Solution {
    int[][] dp;

    public int minInsertions(String s) {
        int n = s.length();
        dp = new int[n][n];
        return solve(s, 0, n - 1);
    }

    public int solve(String s, int i, int j) {
        if (i > j) return 0;
        if (i == j) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = solve(s, i + 1, j - 1);
        } else {
            dp[i][j] = Math.min(
               1 + solve(s, i + 1, j),
               1 + solve(s, i, j - 1)
            );
        }
        return dp[i][j];
    }
}