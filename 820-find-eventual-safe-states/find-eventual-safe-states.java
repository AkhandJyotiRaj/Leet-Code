import java.util.*;

class Solution {

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // Step 1: Reverse Graph
        List<List<Integer>> reverse = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverse.add(new ArrayList<>());
        }

        // Step 2: Outdegree array
        int[] outdegree = new int[n];

        for (int i = 0; i < n; i++) {
            outdegree[i] = graph[i].length;

            for (int neighbor : graph[i]) {
                reverse.get(neighbor).add(i);
            }
        }

        // Step 3: Queue for terminal nodes
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        boolean[] safe = new boolean[n];

        // Step 4: BFS
        while (!q.isEmpty()) {
            int curr = q.poll();
            safe[curr] = true;

            for (int parent : reverse.get(curr)) {
                outdegree[parent]--;

                if (outdegree[parent] == 0) {
                    q.offer(parent);
                }
            }
        }

        // Step 5: Collect result
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (safe[i]) {
                ans.add(i);
            }
        }

        return ans;
    }
}