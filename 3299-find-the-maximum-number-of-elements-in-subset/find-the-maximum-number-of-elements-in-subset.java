class Solution {
    public int maximumLength(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        int ans = 1;
        
        // 1 ko alag handle kar rhe hai
        if (map.containsKey(1)) {
            int cnt = map.get(1);
            ans = Math.max(ans, (cnt % 2 == 0) ? cnt - 1 : cnt);
        }

        for(int i : nums){
            if(i == 1) continue;
            ans = Math.max(ans , helper(map , i , 1));
        }

        return ans;
    }

    public int helper(HashMap<Integer,Integer> map , int i , int len){
        int freq = map.getOrDefault(i,0);

        if(freq == 0){
            return len-2;
        }

        if(freq == 1){
            return len;
        }

        //check overflow 
        if(i > Math.sqrt(Integer.MAX_VALUE)){
            return len;
        }
        return helper(map,i*i,len+2);
    }
}