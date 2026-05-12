class Solution {
     public int lengthOfLIS(int[] nums) {
        int n=nums.length; 
        int dp[][]=new int[n+1][n+1];
        int max = 0;
        for(int i =n-1;i>=0;i--){
            for(int j =i-1;j>=-1;j--){

                int  skip = dp[i+1][j+1];
            
            int take = 0;
            if(j==-1 || nums[i] > nums[j]){
                take  = 1+dp[i+1][i+1];
            }
            dp[i][j+1]=Math.max(take,skip);

            }
        }
         return dp[0][0];




    // public int Lis(int nums[],int idx, int []dp){
       
    //     if(idx==0) return 1;
    //     if(dp[idx]!=-1){
    //         return dp[idx];
    //     }
    //     int max=1;
    //     for(int i=0; i<idx; i++){
    //         if(nums[i]<nums[idx]){
    //            max=Math.max(max,1+Lis(nums,i,dp));
    //         }   
    //     }
    //     dp[idx]=max;
    //     return dp[idx];
    // }
    // public int lengthOfLIS(int[] nums) {
    //     int res=1;
    //     int n=nums.length;
    //     int dp[]=new int[n];
    //     Arrays.fill(dp,-1);
    //     for(int i=0; i<n; i++){
    //         res=Math.max(res,Lis(nums,i,dp));
    //     }
    //     return res; 
        
    }
}