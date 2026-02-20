import java.util.*;

class Solution {
    
    public boolean isBipartite(int V, int[][] edges) {
        
        // Step 1: Create adjacency list
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Add edges (Undirected Graph)
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        int[] color = new int[V];
        Arrays.fill(color, -1);  
        
        // Step 3: Check all components
        for (int i = 0; i < V; i++) {
            
            if (color[i] == -1) {
                if (!bfsCheck(graph, color, i)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    private boolean bfsCheck(ArrayList<ArrayList<Integer>> graph, int[] color, int start) {
        
        Queue<Integer> queue = new LinkedList<>();
        
        queue.add(start);
        color[start] = 0;  // Assign first color
        
        while (!queue.isEmpty()) {
            
            int current = queue.poll();
            
            for (int neighbor : graph.get(current)) {
                
                // If neighbor not colored
                if (color[neighbor] == -1) {
                    color[neighbor] = 1 - color[current]; // Assign opposite color
                    queue.add(neighbor);
                }
                // If neighbor has same color → Not bipartite
                else if (color[neighbor] == color[current]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}