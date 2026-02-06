class Solution {
    public int maximumUniqueSubarray(int[] nums) {

        int maxScore = 0;
        int sum = 0;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        int left = 0;
        for(int right = 0;right<n;right++){
            
            //if duplicate, remove from the left
            while(set.contains(nums[right])){ 
                set.remove(nums[left]);
                sum -= nums[left];
                left++;
            }

            sum += nums[right];
            maxScore = Math.max(sum,maxScore);
            set.add(nums[right]);
        }
        
        return maxScore;
    }
}