class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;

        int ptr =0;

        for(int i=0;i<nums.length;i++){
            if(nums[i]!=nums[ptr]){
                ptr++;
                nums[ptr] = nums[i];

            }
    
        }

        return ptr+1;
    }

}