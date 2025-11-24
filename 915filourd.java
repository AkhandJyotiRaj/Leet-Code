class Solution {
    public int partitionDisjoint(int[] nums) {
        int maxLeft = nums[0];
        int globalMax = nums[0];
        int partition = 0;
        int n = nums.length;
        for(int i=1; i<n; i++){
            if(nums[i] < maxLeft){
                maxLeft = globalMax;
                partition = i;
            }else{
                globalMax = Math.max(globalMax, nums[i]);
            }
        }
        return partition+1;
    }
}