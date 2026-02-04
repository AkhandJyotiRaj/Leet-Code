class Solution {
    public double findMaxAverage(int[] nums, int k) {
        
        int windowstart = 0;
        int windowend=0;
         int currsum=0;
        int maxsum = Integer.MIN_VALUE;

        while(windowend < nums.length){
            currsum += nums[windowend];

            if(windowend >= k-1){
                maxsum = Math.max(currsum,maxsum);
                currsum -= nums[windowstart];
                windowstart++;

            }
            windowend++;
        }
        return (double) maxsum/k;
    }
}