class Solution {

    public int findTargetSumWays(int[] nums, int target) {

        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if (target > sum || target < -sum) {
            return 0;
        }

        int dp[][] = new int[nums.length + 1][2 * sum + 1];

        dp[0][sum] = 1;

        for (int i = 1; i <= nums.length; i++) {

            int num = nums[i - 1];

            for (int s = -sum; s <= sum; s++) {

                if (dp[i - 1][s + sum] != 0) {

                    dp[i][s + num + sum] += dp[i - 1][s + sum];

                    dp[i][s - num + sum] += dp[i - 1][s + sum];
                }
            }
        }

        return dp[nums.length][target + sum];
    }
}