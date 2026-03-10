class Solution {
    class DSU{
        int[]parent;
        int[]rank;
        DSU(int n){
            parent=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++){
                parent[i]=i;
            }
        }
        public void union(int a,int b){
            int pa=find(a);
            int pb=find(b);
            if(pa==pb) return;
            if(rank[pa]>rank[pb]){
                parent[pb]=pa;
            }
            else if(rank[pb]>rank[pa]){
                parent[pa]=pb;
            }
            else{
                parent[pb]=pa;
                rank[pa]++;
            }
        }
        public int find(int node){
            if(parent[node]==node) return node;
            return parent[node]=find(parent[node]);
        }
    }
    public int makeConnected(int n, int[][] connections) {
        DSU obj=new DSU(n);
        int m=connections.length;
        if(m<n-1) return -1;
        int totalComp=n;
        for(int i=0;i<m;i++){
            int a=connections[i][0];
            int b=connections[i][1];
            int pa=obj.find(a);
            int pb=obj.find(b);
            if(pa!=pb) totalComp--;
            obj.union(pa,pb);
        }
        return totalComp-1;
        
    }
}