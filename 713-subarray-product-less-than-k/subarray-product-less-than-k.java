class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        
        if (k <= 1) return 0;

        int n = nums.length;
        int start = 0;
        int prod = 1;
        int count = 0;

        for (int end = 0; end < n; end++) {
            
            prod *= nums[end];

            while (prod >= k) {
                prod /= nums[start];
                start++;
            }

            count += (end - start + 1);
        }

        return count;
    }
}
