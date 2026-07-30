class Solution {
    public int minimumPushes(String word) {
        int gm=0;
        for(int i=0;i<word.length();i++)
        {
            gm+=i/8+1;
        }
        return gm;
    }
}