class DSU{
    int[] parent;
    public DSU(int n){
        parent = new int[n];
        for(int i=0;i<n;i++) parent[i] = i;
    }
    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    public void union(int x, int y){
        parent[find(x)] = parent[find(y)];
    }
}
class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        HashSet<Integer> edge = new HashSet<>();
        DSU alice = new DSU(n);
        DSU bob = new DSU(n);
        for(int[] e:edges){
            e[1]--;
            e[2]--;
        }

        for(int i=0;i<edges.length;i++){
            int[] e = edges[i];
            if(e[0] == 3){
                if(alice.find(e[1]) != alice.find(e[2])){
                    edge.add(i);
                    alice.union(e[1], e[2]);
                }
            }
        }
        for(int i=0;i<edges.length;i++){
            int[] e = edges[i];
            if(e[0] == 1){
                if(alice.find(e[1]) != alice.find(e[2])){
                    edge.add(i);
                    alice.union(e[1], e[2]);
                }
            }
        }
        //Bob
        for(int i=0;i<edges.length;i++){
            int[] e = edges[i];
            if(e[0] == 3){
                if(bob.find(e[1]) != bob.find(e[2])){
                    edge.add(i);
                    bob.union(e[1], e[2]);
                }
            }
        }
        for(int i=0;i<edges.length;i++){
            int[] e = edges[i];
            if(e[0] == 2){
                if(bob.find(e[1]) != bob.find(e[2])){
                    edge.add(i);
                    bob.union(e[1], e[2]);
                }
            }
        }
        if(comp(alice)!=1 || comp(bob)!=1) return -1;
        return edges.length - edge.size();
    }
    public int comp(DSU dsu){
        HashSet<Integer> v = new HashSet<>();
        int compo = 0;
        for(int i=0;i<dsu.parent.length;i++){
            int p = dsu.find(i);
            if(v.contains(p)) continue;
            v.add(p);
            compo++;
            if(compo>=2) break;
        }
        return compo;
    }
}