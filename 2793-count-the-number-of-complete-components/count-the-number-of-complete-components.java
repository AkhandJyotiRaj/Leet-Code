public class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new ArrayList[n];
        Map<List<Integer>, Integer> componentFreq = new HashMap<>();
        for (int v = 0; v < n; v++) {
            graph[v] = new ArrayList<>();
            graph[v].add(v);
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        for (int v = 0; v < n; v++) {
            List<Integer> neighbors = graph[v];
            Collections.sort(neighbors);
            componentFreq.put(neighbors, componentFreq.getOrDefault(neighbors, 0) + 1);
        }
        int result = 0;
        for (Map.Entry<List<Integer>, Integer> entry : componentFreq.entrySet()) 
            if (entry.getKey().size() == entry.getValue()) result++;
        return result;
    }
}