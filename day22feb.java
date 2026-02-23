import java.util.*;

class Solution {
    
    public int[] shortestPath(int V, int[][] edges, int src) {
        
        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Step 2: Fill adjacency list (undirected graph)
        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Step 3: Initialize distance array
        int[] dist = new int[V];
        Arrays.fill(dist, -1);
        
        // Step 4: BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        dist[src] = 0;
        
        while(!queue.isEmpty()) {
            int node = queue.poll();
            
            for(int neighbor : adj.get(node)) {
                if(dist[neighbor] == -1) {
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return dist;
    }
}