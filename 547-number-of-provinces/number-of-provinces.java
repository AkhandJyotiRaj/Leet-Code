class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        
        boolean visited[] = new boolean[n];
       
        int count = 0;

        for(int i = 0; i<n; i++){
            if(!visited[i]){
                helper(i, isConnected, visited, n);
                count++;
            }
        }
        return count;
    }

     public void helper(int start, int[][] isConnected, boolean visited[], int n){

             Queue<Integer> q = new LinkedList<>();
             q.offer(start);
             visited[start] = true;

             while(!q.isEmpty()){
                int node = q.poll();

                for(int i = 0;i<n;i++){
                    if(isConnected[node][i] ==1 && !visited[i]){
                        visited[i] = true;
                        q.offer(i);
                    }
                }
             }
     }
}