class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i ++){
            for(int j = 0; j < nums.length - i - 1; j ++){
                if(nums[j] > nums[j + 1]){
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for(int k = 0; k < nums.length; k ++){
            if(nums[k] == target)
               list.add(k);
        }
        return list;
    }
}