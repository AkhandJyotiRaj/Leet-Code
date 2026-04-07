class Solution {
    public int path(int m ,int n, int dp[][]){
        if(m==1 || n==1) return 1;
        if(dp[m][n] != -1) return dp[m][n];
        return dp[m][n]= path(m-1,n,dp) + path(m,n-1,dp);
    }
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m+1][n+1];
        for( int i = 0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return path(m,n,dp);
        
    }
}