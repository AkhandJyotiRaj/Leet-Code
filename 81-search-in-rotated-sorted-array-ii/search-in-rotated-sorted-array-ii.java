class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while(right >= left){
           int mid = left + ( right - left ) / 2;

            if(nums[mid] == target) return true;

            if(nums[mid] == nums[left] && nums[mid] == nums[right]){
                left++;
                right--;
            }

           else if(nums[left] <= nums[mid]){ // target is in sorted left half
                if(target < nums[mid] && target >= nums[left]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
                }
            else{ // target is in sorted right half
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
            }
            }
        }
        return false;
    }
}