class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }
        
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                provinces++;
            }
        }
        return provinces;
    }
    
    class DSU {
        int[] parent;
        
        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        
        int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        void union(int x, int y) {
            int rx = find(x);
            int ry = find(y);
            if (rx != ry) {
                parent[rx] = ry;
            }
        }
    }
}