class Solution {
    public int findMaxLength(int[] nums) {
        
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int maxlen = 0;
        int sum = 0;
        int n = nums.length;
        for(int i =0; i<n;i++){
            sum = sum + ((nums[i] ==0) ?-1:1);
            if(map.containsKey(sum)){
                int len = i - map.get(sum);
                maxlen = Math.max(maxlen,len);
            }
            else {
                map.put(sum,i);
            }
        }
        return maxlen;
    }
}