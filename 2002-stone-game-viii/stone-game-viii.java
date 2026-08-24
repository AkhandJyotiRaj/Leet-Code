class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int[] prefix = new int[n];
        prefix[0] = stones[0];
        for(int i=1;i<n;i++){
            prefix[i] = prefix[i-1]+stones[i];
        }
        //Now we start comparing from last[prefix] to first[prefix] to get the max possible diff..//
        int ans = prefix[n-1];
        for(int i=n-2;i>0;i--){  // >0 not >=0 bcoz alice have to take atleast 2 stones thats why >0..//
            int finalans = prefix[i] - ans;
            ans = Math.max(ans, finalans);
        }
        return ans;
    }
}