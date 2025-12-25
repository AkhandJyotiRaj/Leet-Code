class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        int[] son = new int[n];
        int[] parent = new int[n];
        List<Integer>[] paths = new ArrayList[n];
        for(int i = 0; i < n; i++){
            paths[i] = new ArrayList<>();
        }
        for(int[] x: edges){
            paths[x[0]].add(x[1]);
            paths[x[1]].add(x[0]);
        }

        dfs(-1, 0, paths, son, parent);
        Queue<Integer> qe = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(son[i] == 0) qe.add(i);
        }

        int cnt = 0;
        while(!qe.isEmpty()){
            int leaf = qe.poll();
            int p = parent[leaf];

            if(values[leaf] % k == 0) cnt++;
            else if(p >= 0){
                values[p] = (values[p] % k + values[leaf] % k) % k;
            }

            if(p >= 0){
                son[p]--;
                if(son[p] == 0) qe.add(p);
            }
        }

        return cnt;
    }

    private void dfs(int p, int u, List<Integer>[] paths, int[] son, int[] parent){
        if(p >= 0) son[p]++;
        parent[u] = p;

        for(int v: paths[u]){
            if(v != p){
                dfs(u, v, paths, son, parent);
            }
        }
    }
}