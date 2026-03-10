class Solution {
    int[] parent;
    int[] size;
    public void init(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
    public boolean union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA==parentB) return false;

        if(size[parentA]>=size[parentB]){
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }else{
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        init(n+1); // initialize DSU
        int[] res = new int[2];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            if(!union(u, v)){ // if already in a same group
                // that edge can be a valid ans
                res[0] = u;
                res[1] = v;
            }
        }
        return res;
    }
}