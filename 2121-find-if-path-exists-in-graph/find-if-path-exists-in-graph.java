class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0 ;i<n ;i++){
            adj.add(new ArrayList<>());
        }

        for( int i = 0; i<edges.length;i++){
            int u = edges[i][0];
            int V = edges[i][1];

            adj.get(u).add(V);
            adj.get(V).add(u);
        }
        
    
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();

        q.offer(source);
        visited[source] = true;

        while(!q.isEmpty()){
            int node = q.poll();
    

            for(int edge:adj.get(node)){
                if(!visited[edge]){
                    visited[edge] = true;
                    q.offer(edge);
                }
            }
        }
        return visited[destination];

    }
}