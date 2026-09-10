class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<n;i++){
            for(int j = 0;j<graph[i].length;j++){
                int v = graph[i][j];
                adj.get(i).add(v);
            }
        }

        boolean visited[] = new boolean[n];
        boolean path[] = new boolean[n];
        boolean find[] = new boolean[n];

        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i,adj,visited,path,find);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            if(find[i]){
                ans.add(i);
            }
        }
        return ans;

    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean visited[], boolean path[],boolean find[]){

        visited[node] = true;
        path[node] = true;

        for(int neigh:adj.get(node)){
            if(!visited[neigh]){
                if(dfs(neigh,adj,visited,path,find)){
                    return true;
                }
            }
            else if(path[neigh]){
                return true;
            }
        }
        path[node] = false;
        find[node]= true;
        return false;

    }

}








