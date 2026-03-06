class Solution {

    public long solve(int i, int state, int[] nums, Long[][] dp) {
        if (i == nums.length) return 0;

        if (dp[i][state] != null) return dp[i][state];

        long take;
        
        if (state == 0) { 
            take = nums[i] + solve(i + 1, 1, nums, dp);
        } else { 
            take = -nums[i] + solve(i + 1, 0, nums, dp);
        }

        long notTake = solve(i + 1, state, nums, dp);

        return dp[i][state] = Math.max(take, notTake);
    }

    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        Long[][] dp = new Long[n][2];
        return solve(0, 0, nums, dp);
    }
}