class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n = graph.length;

        boolean visited[] = new boolean[n];
        boolean path[] = new boolean[n];
        boolean find[] = new boolean[n];

        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i,graph,visited,path,find);
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

    public boolean dfs(int node, int[][] graph, boolean visited[], boolean path[],boolean find[]){

        visited[node] = true;
        path[node] = true;

        for(int neigh:graph[node]){
            if(!visited[neigh]){
                if(dfs(neigh,graph,visited,path,find)){
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








