class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int mx = 0;
        int zero = -1;

        for(int right = 0; right<n;right++){
            if(nums[right] ==0){
                left = zero +1;
                zero = right;
            }
            mx = Math.max(mx,right -left);
        }
        return mx;
    }
}