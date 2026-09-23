class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        // The target sum we want to find inside our sliding window
        int target = totalSum - x;
        
        // If target is 0, it means we need to remove all elements
        if (target == 0) {
            return nums.length;
        }
        // If target is negative, it's impossible to reduce x to 0 
        if (target < 0) {
            return -1;
        }
        
        int maxLen = -1;
        int currentSum = 0;
        int left = 0;
        
        // Sliding window
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Shrink the window from the left if the current sum exceeds our target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            // Check if we hit the exact target sum
            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        // If maxLen was updated, return the remaining elements; otherwise return -1
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}