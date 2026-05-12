class Solution {
    public int lengthOfLIS(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length + 1];
        return solve(0, -1, nums, dp);
    }

    private int solve(int index, int prev, int[] nums, Integer[][] dp) {
        if (index == nums.length) {
            return 0;
        }

        if (dp[index][prev + 1] != null) {
            return dp[index][prev + 1];
        }

        int skip = solve(index + 1, prev, nums, dp);

        int take = 0;
        if (prev == -1 || nums[index] > nums[prev]) {
            take = 1 + solve(index + 1, index, nums, dp);
        }

        return dp[index][prev + 1] = Math.max(take, skip);
    }
}