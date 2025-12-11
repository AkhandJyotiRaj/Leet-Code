class Solution {
    public int minimumTotal(List<List<Integer>> triangle){
        int m = triangle.size();        
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < m; i++){
            int n = triangle.get(i).size();
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                else{
                    int down = (j != n - 1) ? dp[i - 1][j] : Integer.MAX_VALUE;
                    int diagonal = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                    dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
                }
            }
        } 
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i <m; i++){
            answer = Math.min(answer, dp[m - 1][i]);

        }     
        return answer;  
    }
}