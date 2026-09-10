class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v);
        }


        boolean visited[] = new boolean[n];
        boolean path[] = new boolean[n];

        for(int i = 0;i<n;i++){
            if(!visited[i]){
                if(dfs(i,adj,visited,path)){
                    return false;
                }
            }
        }
            return true;

    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> adj  ,boolean visited[], boolean path[]){
        visited[node] = true;
        path[node] = true;

        for(int neigh:adj.get(node)){
            if(!visited[neigh]){
                if(dfs(neigh,adj,visited,path)){
                    return true;
                }
            }
            else if(path[neigh]){
                return true;
            }
        }
        path[node] =false;
        return false;
    }

}