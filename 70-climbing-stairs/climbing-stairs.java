// class Solution {

    // top down

// public int climbStairs(int n) {

//      int[] dp = new int[n + 1];
//      Arrays.fill(dp,-1);
//         return climb(n, dp);
//     }

//     public int climb(int n, int[] dp) {
//         if (n <= 2) return n;                 
//         if (dp[n] != -1) return dp[n];     
//         dp[n] = climb(n - 1, dp) + climb(n - 2, dp);
//         return dp[n];


//     }
// }

// bottom down apporaoch
// class Solution {

// public int climbStairs(int n) {
//     if(n<=2) return n;

//      int[] dp = new int[n + 1];
//      dp[1] = 1;
//      dp[2] = 2;

//      for(int i=3;i<=n;i++){
//             dp[i] = dp[i-1] + dp[i-2];

//         }
//         return dp[n];

//     }
// }

// spcace 

class Solution {

public int climbStairs(int n) {
    if(n<=2) return n;

    int p1 = 1;
    int p2 = 2;

     for(int i=3;i<=n;i++){
        int curr = p1 + p2;
        p1 = p2;
        p2 = curr;

        }
        return p2;

    }
}

