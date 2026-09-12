class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0,graph,ans,path);
        return ans;
    }
        public void dfs(int node,int[][] graph,List<List<Integer>> ans, ArrayList<Integer> path ){

            if(node == graph.length -1){
                ans.add(new ArrayList<>(path));
                return;
            }

            for(int neigh:graph[node]){
                path.add(neigh);
                dfs(neigh,graph,ans,path);
                path.remove(path.size()-1);
            }
        }
        



    
}

