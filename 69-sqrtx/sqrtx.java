class Solution {
    public int mySqrt(int x) {
        
        if(x<=1)return x;
        long lo = 0;
        long hi = x;
        while(lo<=hi){
            long mid = (lo+hi)/2;
            if(mid*mid == x)return (int)mid;
            else if(mid>x/mid)hi = mid-1;
            else lo = mid+1;
        }
        return (int)hi;
    }
}