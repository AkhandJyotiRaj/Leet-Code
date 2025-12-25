// class Solution {
//     public int fib(int n) {
//         if (n==0)  return 0;

//         int[] dp = new int[n+1];
//         dp[0] = 0;
//         dp[1] = 1;

//         for(int i=2;i<=n;i++){
//             dp[i] = dp[i-1] + dp[i-2];

//         }
//         return dp[n];
//     }


// }

class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        
        int p1 = 0;
        int p2 = 1;
        for(int i =2;i<=n;i++){
            int curr = p1 + p2;
            p1 = p2;
            p2 = curr;
        }
        return p2;
    }


}