class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        boolean visited[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();


        for(int i = 0 ;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);

        }

        q.offer(source);
        visited[source] =  true;

        while(!q.isEmpty()){
            int node = q.poll();
            if(node == destination){
                return true;
            }
            for(int neigh : adj.get(node)){
                if(!visited[neigh]){
                    visited[neigh] = true;
                    q.offer(neigh);
                }
            }
        }
        return false;


    }
}