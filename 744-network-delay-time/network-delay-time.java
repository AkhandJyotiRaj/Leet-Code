import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge : times){
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];
            
            if(time > dist[node]) continue;
            
            for(int[] neighbor : graph.get(node)){
                int next = neighbor[0];
                int weight = neighbor[1];
                
                if(dist[node] + weight < dist[next]){
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{dist[next], next});
                }
            }
        }
        
        int max = 0;
        for(int i = 1; i <= n; i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }
        
        return max;
    }
}