class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int maxdiff = n - 1;
        int first = nums[0];

        for (int i = 1; i < n; ++i) {
            int d = Math.abs(nums[i] - nums[i - 1]);
            if (d != 1 && d != maxdiff) {
                return -1;
            }
        }

        if (n == 1 || (first == 0 && nums[1] == 1)) {
            return 0;
        }
        return Math.min(n - first, first + 2);
    }
}