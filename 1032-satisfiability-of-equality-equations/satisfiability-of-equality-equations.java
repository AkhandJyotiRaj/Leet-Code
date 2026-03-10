class Solution {
    class DSU{
        int[] parent;

        DSU(int n){
            parent = new int[n+1];
            for(int i = 0; i <= n; i++){
                parent[i] = i;
            }
        }

        int find(int x){
            if(parent[x] == x){
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        void union(int a, int b){
            int pa = find(a);
            int pb = find(b);

            if(pa != pb){
                parent[pb] = pa;
            }
        }
    }

    public boolean equationsPossible(String[] equations) {

        DSU dsu = new DSU(26);

        // Step 1: process all ==
        for(String eq : equations){
            if(eq.charAt(1) == '='){
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                dsu.union(a, b);
            }
        }

        // Step 2: check all !=
        for(String eq : equations){
            if(eq.charAt(1) == '!'){
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';

                if(dsu.find(a) == dsu.find(b)){
                    return false;
                }
            }
        }

        return true;
    }
}