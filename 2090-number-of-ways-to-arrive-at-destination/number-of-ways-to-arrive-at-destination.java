class Solution {
    class Node{
        int src;
        int dest;
        int wt;
        Node(int src, int dest, int wt){
            this.src=src;
            this.dest=dest;
            this.wt=wt;
        }
    }
    class Pair implements Comparable<Pair>{
        long shortestDist;
        int node;
        Pair(int node, long shortestDist){
            this.shortestDist=shortestDist;
            this.node=node;
        }
        public int compareTo(Pair p2){
            return Long.compare(this.shortestDist, p2.shortestDist);
        }
    }
    public int countPaths(int n, int[][] roads) {
        int MOD = (int)1e9 + 7;
        @SuppressWarnings("unchecked")
        ArrayList<Node>[] graph = new ArrayList[n]; 
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];
            graph[u].add(new Node(u, v, wt));
            graph[v].add(new Node(v, u, wt));
        }

        boolean[] isVisited = new boolean[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;
        
        pq.add(new Pair(0, 0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            if(!isVisited[curr.node]){
                isVisited[curr.node] = true;
                
                for(Node neighbour : graph[curr.node]){
                    int u = neighbour.src;
                    int v = neighbour.dest;
                    int w = neighbour.wt;
                    if(dist[u]!=Integer.MAX_VALUE && dist[u] + w < dist[v]){
                        dist[v] = dist[u] + (long)w;
                        ways[v] = ways[u];
                        pq.add(new Pair(v, dist[v]));
                    }else if(dist[u]!=Integer.MAX_VALUE && dist[u] + w == dist[v]){
                        ways[v] = (ways[v] + ways[u])%MOD;
                    }
                }
            }
        }
        return ways[n-1];
    }
}