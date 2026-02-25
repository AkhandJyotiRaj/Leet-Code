class Solution {
    static class pair{
        int node;
        double dist;
        public pair(int node,double dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succProb, int sn, int en) {
        ArrayList<ArrayList<pair>>list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }double[]dist=new double[n];
        dist[sn]=1;
        for(int i=0;i<edges.length;i++){
            int u= edges[i][0];
            int v=edges[i][1];
            double w=succProb[i];
            list.get(u).add(new pair(v,w));
            list.get(v).add(new pair(u,w));
        }PriorityQueue<pair>q=new PriorityQueue<>((a,b)->Double.compare(b.dist,a.dist));
        q.offer(new pair(sn,1));
        while(!q.isEmpty()){
            pair curr=q.remove();
            int u=curr.node;
            double w=curr.dist;
            if(dist[u]>w)continue;
            for(pair a:list.get(u)){
                int v=a.node;
                double W=a.dist;
                if(dist[v]<dist[u]*W){
                    dist[v]=dist[u]*W;
                    q.offer(new pair(v,dist[v]));
                }
            }
        }return dist[en];
    }
}