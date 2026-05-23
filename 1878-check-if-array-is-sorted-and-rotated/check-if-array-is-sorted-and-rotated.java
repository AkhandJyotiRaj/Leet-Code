class Solution {
    public boolean check(int[] nums) {
       int incIndex=-1,descIndex=-1,count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]>nums[i]){
                incIndex=i;
                descIndex=i-1;
                count++;
            }
        }
        if(count>1)return false;
        if(incIndex==-1)return true;
        return incCheck(nums,incIndex)&&descCheck(nums,descIndex)&&nums[nums.length-1]<=nums[0];
    }
    public static boolean incCheck(int[]arr,int index){
        for(int i=index;i<arr.length-1;i++){
            if(arr[i]>arr[i+1])return false;
        }
        return true;
    }
    public static boolean descCheck(int[]arr,int index){
        for(int i=index;i>0;i--){
            if(arr[i]<arr[i-1])return false;
        }
        return true;
    }
}