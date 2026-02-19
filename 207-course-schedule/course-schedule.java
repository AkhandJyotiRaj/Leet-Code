class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < V;i++){
            adj.add(new ArrayList<>());
        }
        for(int  i = 0;i < prerequisites.length;i++){
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            adj.get(u).add(v); 
        }
        int indegree[] = new int[V];
        for(int i = 0;i < V;i++){
            for(int neigh : adj.get(i)){
                indegree[neigh]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0;i < indegree.length;i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        int c = 0;
        while(!queue.isEmpty()){
            int curr = queue.poll();
            c++;
            for(int neigh : adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh] == 0){
                    queue.add(neigh);
                }
            }
        }
        return (c == V);
    }
}