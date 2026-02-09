public class bfsingraphingfg {
    
}
import java.util.*;

class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> res = new ArrayList<>();
        
        Queue<Integer> q = new LinkedList<>();
        
        visited[0] = true;
        q.add(0);
        
        while(!q.isEmpty()){
            int src = q.poll();
            res.add(src);
            
            for(int i = 0; i < adj.get(src).size(); i++){
                int neighbour = adj.get(src).get(i);
                a
                if(visited[neighbour]== false){
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        
        return res;
    }
}
