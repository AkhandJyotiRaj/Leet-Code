class Solution {
    public int removeBoxes(int[] boxes) {
        int dp[][][] = new int[boxes.length][boxes.length][boxes.length];
        return remove(boxes, 0, boxes.length - 1, 0, dp);
    }
    public int remove(int[] boxes, int i, int j, int k, int [][][] dp){
        if(i > j){
            return 0;
        }
        if(i == j){
            return (k + 1) * (k + 1);
        }

        if(dp[i][j][k] != 0){
            return dp[i][j][k];
        }
        dp[i][j][k] = (k + 1) * (k + 1)  +  remove(boxes, i + 1, j, 0, dp);

        for(int l = i + 1; l <= j ; l++){
            if(boxes[i] == boxes[l]){
                dp[i][j][k] = Math.max(dp[i][j][k], remove(boxes, i + 1, l - 1, 0, dp) + remove(boxes, l, j, k + 1, dp));
            }
        }
        return dp[i][j][k];
    }
}