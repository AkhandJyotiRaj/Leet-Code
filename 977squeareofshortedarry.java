class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] ans = new int[nums.length];

        int st = 0;
        int ed = nums.length-1;
        int ptr = ans.length-1;

        while(st<=ed){
            int ss = nums[st] * nums[st];
            int es = nums[ed] * nums[ed];

            if(ss>es){
                ans[ptr]=ss;
                st++;
            }
            else {
                ans[ptr]=es;
                ed--;
            }
            ptr--;
        }
        return ans;
    }
}