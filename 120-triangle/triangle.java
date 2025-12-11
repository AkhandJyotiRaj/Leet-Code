class Solution {
    public int minimumTotal(List<List<Integer>> triangle){
        int m = triangle.size();
        int[] curr = new int[m];
        int[] prev = new int[m];
        prev[0] = triangle.get(0).get(0);
        for(int i = 1; i < m; i++){
            int n = triangle.get(i).size();
            for(int j = 0; j < n; j++){
                if(i == 0 && j == 0) continue;
                else{
                    int down = (j != n - 1) ? prev[j] : Integer.MAX_VALUE;
                    int diagonal = (j > 0) ? prev[j - 1] : Integer.MAX_VALUE;
                    curr[j] = triangle.get(i).get(j) + Math.min(down, diagonal);
                }
            }
            prev = curr.clone();
        } 
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i <m; i++){
            answer = Math.min(answer, prev[i]);

        }     
        return answer;  
    }
}