class Solution {
    long mod= (long)1e9 + 7;
    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    public long helper(int[] nums, int i ,int gcd1, int gcd2, long dp[][][]){
        if(i>=nums.length){
            // System.out.println(gcd1+" "+gcd2);
            if(gcd1==201 || gcd2==201){
                return 0;
            }
            else if(gcd1==gcd2) return 1;
            else return 0;
        }
        if(dp[i][gcd1][gcd2]!=-1) return dp[i][gcd1][gcd2];
        long ans=0;
        // pick for 1st
        if(gcd1==201){
            ans+=helper(nums, i+1,nums[i], gcd2,dp);
        }
        else{
            ans+=helper(nums,i+1, gcd(nums[i],gcd1), gcd2,dp);
        }
        // pick for 2st 
        if(gcd2==201){
            ans+=helper(nums, i+1,gcd1,nums[i],dp);
        }
        else{
            ans+=helper(nums,i+1, gcd1, gcd(nums[i],gcd2),dp);
        }
        // not pick 
        ans+=helper(nums,i+1, gcd1, gcd2,dp);
        return dp[i][gcd1][gcd2]=(ans%mod);
    }
    
    public int subsequencePairCount(int[] nums) {
        long dp[][][]=new long[nums.length+1][202][202];
        for(long arr[][]:dp){
            for(long ar[]:arr){
                Arrays.fill(ar,-1);
            }
        }
        return (int)helper(nums, 0,201, 201,dp);
    }
}