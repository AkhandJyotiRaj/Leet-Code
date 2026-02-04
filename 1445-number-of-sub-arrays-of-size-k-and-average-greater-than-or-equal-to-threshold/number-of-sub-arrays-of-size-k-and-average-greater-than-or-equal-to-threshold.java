class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {

        int sum = 0;
        int count = 0;
        int maxth  = k * threshold;

        int i =0;
        for(i = 0;i<k;i++){
            sum = sum + arr[i];
        }
        if(sum>=maxth){
                count++;
            }
        
        while ( i< arr.length){
            sum = sum + arr[i] - arr[i-k];
            if(sum>=maxth){
                count++;
            }
            i++;
        }
        return count;

    }
}