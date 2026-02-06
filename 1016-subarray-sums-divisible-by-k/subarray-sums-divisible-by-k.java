class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int st = 0;
        int end = 0;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  


        for(int j = 0;j<n;j++){
            sum = sum + nums[j];
            int rem = sum % k;
            if(rem<0){
                rem += k;
            }
            if(map.containsKey(rem)){ 
                 count+=map.get(rem);
                }
            map.put(rem,map.getOrDefault(rem,0)+1);  
            
        
        }
        return count;
    }
}