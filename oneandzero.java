class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] pair=new int[strs.length][2];
        int index=0;
        for(String s:strs){
            int zero=0;
            int one=0;
            for(char ch:s.toCharArray()){
                if(ch=='0'){
                    zero++;
                }else{
                    one++;
                }
            }
            pair[index][0]=zero;
            pair[index][1]=one;
            index++;
        }
        return sub(pair,0,m,n);
    }
    private int sub(int[][] pair, int index, int m, int n){

        if(index==pair.length ||(m==0 && n==0))return 0;

        if(pair[index][0]>m || pair[index][1] >n) {
            return sub(pair,index+1,m,n);
        }

        return Math.max(1+sub(pair,index+1,m-pair[index][0], n-pair[index][1]),
            sub(pair,index+1,m,n));


    }
}