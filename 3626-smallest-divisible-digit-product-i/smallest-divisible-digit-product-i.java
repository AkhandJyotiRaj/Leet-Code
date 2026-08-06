class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(digipro(n)%t == 0){
                return n;
            }
            n++;
        }
    }

    public static int digipro(int n ){
        int pro = 1;
        while(n>0){
            int d = n%10;
            pro *= d;
            n /= 10;
              }
              return pro;
    }
}