class Solution {

    public int maxrob(int[] nums, int idx, int end, int[] dp){
        if(idx>end) return 0;
        if(dp[idx]!= -1) return dp[idx];

        int steal = nums[idx] + maxrob(nums,idx+2,end,dp);
        int skip = maxrob(nums,idx+1,end,dp);
        return dp[idx] = Math.max(steal,skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0];
        
        //case 1 jab last add nhi hoga;
        int[] dp1 = new int[n];
        Arrays.fill(dp1,-1);
        int case1 = maxrob(nums,0,n-2,dp1);

        int[] dp2 = new int[n];
        Arrays.fill(dp2,-1);
        int case2 = maxrob(nums,1,n-1,dp2);
        return Math.max(case1,case2);
    }
}