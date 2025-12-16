// class Solution {
//     public int solve(int i,int j,int n,int m,int[][] dungeon,int[][] dp){
//         if((i==n-1) && (j==m-1)){
//             if(dungeon[i][j]>0) return 1;
//             else return  Math.abs(dungeon[i][j])+1;
//         }

//         if(i>=n || j>=m) return Integer.MAX_VALUE;

//         if(dp[i][j]!=-1) return dp[i][j];

//         int down=solve(i+1,j,n,m,dungeon,dp);
//         int right=solve(i,j+1,n,m,dungeon,dp);

//         int check=Math.min(down,right)-dungeon[i][j];
//         if(check>0){
//             return dp[i][j]=check;
//         }
//         return dp[i][j]=1;
//     }
//     public int calculateMinimumHP(int[][] dungeon) {
//         int n=dungeon.length;
//         int m=dungeon[0].length;
//         int[][] dp=new int[n][m];
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 dp[i][j]=-1;
//             }
//         }

//         return solve(0,0,n,m,dungeon,dp);
//     }

    // public boolean solve(int i,int j,int mid,int[][] dungeon){
    //  if(mid<=0) return false;
    //  if(i>=dungeon.length || j>=dungeon[0].length){
    //     return false;
    //  }
    //  if(i==dungeon.length-1 && j==dungeon[0].length-1){
    //     if(mid+dungeon[i][j]>=1)return true;
    //     else return false;
    //  }

    //  boolean down=solve(i+1,j,mid+dungeon[i][j],dungeon);
    //  boolean right=solve(i,j+1,mid+dungeon[i][j],dungeon);
  
    // return down||right;
     
    // }
    // public int calculateMinimumHP(int[][] dungeon) {
    //     int low=1;
    //     int high=(int)4e7;
    //     int result=0;
    //     while(low<=high){
    //         int mid=low+(high-low)/2;
    //         boolean check=solve(0,0,mid,dungeon);
    //         if(check){
    //             result=mid;
    //             high=mid-1;
    //         }
    //          else low=mid+1;
    //     }

    //     return result;
    // }
// }

public class Solution {
    public int solve(int i, int j, int[][] dungeon, int[][] dp) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // Base case: Bottom-right cell (princess's room)
        if (i == m - 1 && j == n - 1) {
            return Math.max(1, 1 - dungeon[i][j]);
        }

        // If out of bounds
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        // If the value is already calculated
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Recursive calculation for the minimum health needed
        int right = solve(i, j + 1, dungeon, dp);
        int down = solve(i + 1, j, dungeon, dp);

        // The knight needs at least 1 health point to survive
        int min_health = Math.min(right, down) - dungeon[i][j];
        dp[i][j] = Math.max(1, min_health);

        return dp[i][j];
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        // Create a memoization table initialized with -1
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Start from the top-left cell
        return solve(0, 0, dungeon, dp);
    }
}