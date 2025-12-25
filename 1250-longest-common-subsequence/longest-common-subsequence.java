// class Solution {
//     public int longestCommonSubsequence(String text1, String text2) {
//         return solve(text1, text2, text1.length(), text2.length());
//     }
//     public static int solve(String t1, String t2, int m,int n){
//         if(m==0 || n==0) return 0;
//         if(t1.charAt(m-1)==t2.charAt(n-1)){
//             return 1 + solve(t1, t2, m-1, n-1);
//         }else{
//             return 0 + Math.max(solve(t1, t2, m-1, n), solve(t1, t2, m, n-1));
//         }
//     }
// }


class Solution {   //memorization
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }
        
        return solve(text1, text2, m, n, dp);
    }

    public static int solve(String t1, String t2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) return 0;
        
        if (dp[m][n] != -1) return dp[m][n];
        
        if (t1.charAt(m - 1) == t2.charAt(n - 1)) {
            dp[m][n] = 1 + solve(t1, t2, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(
                solve(t1, t2, m - 1, n, dp),
                solve(t1, t2, m, n - 1, dp)
            );
        }
        
        return dp[m][n];
    }
}