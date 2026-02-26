class Solution {
   
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        List<int[]>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        
        for(int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }
          PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        pq.offer(new int[]{passingFees[0], 0, 0});
        
        int[][] minTime = new int[n][maxTime + 1];
        for(int i = 0; i < n; i++) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            
            int cost = curr[0];
            int city = curr[1];
            int time = curr[2];
            
            if(city == n - 1) return cost;
            
            if(time > maxTime) continue;
            
            if(minTime[city][time] <= cost) continue;
            
            minTime[city][time] = cost;
            
            for(int[] nei : graph[city]) {
                int nextCity = nei[0];
                int travelTime = nei[1];
                
                int newTime = time + travelTime;
                int newCost = cost + passingFees[nextCity];
                
                if(newTime <= maxTime) {
                    pq.offer(new int[]{newCost, nextCity, newTime});
                }
            }
        }
        
        return -1;
    }
}