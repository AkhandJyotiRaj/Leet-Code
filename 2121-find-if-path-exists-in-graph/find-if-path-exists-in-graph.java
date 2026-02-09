class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> arr=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            arr.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            arr.get(u).add(v);
            arr.get(v).add(u);
        }
        boolean b[]=new boolean[n];
        Arrays.fill(b,false);
        Queue<Integer>q =new LinkedList<>();
        q.add(source);
        b[source]=true;
        while(q.size()!=0){
            if(q.peek()==destination) return true;
            for(int i:arr.get(q.peek())){
                if(!b[i]){
                    q.add(i);
                    b[i]=true;
                }
            }
            q.remove();
        }
        return b[destination];
    }
}