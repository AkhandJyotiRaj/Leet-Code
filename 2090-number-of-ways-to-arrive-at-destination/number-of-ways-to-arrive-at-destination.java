import java.util.*;
class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007;
        List<List<long[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            graph.get(u).add(new long[]{v, w});
            graph.get(v).add(new long[]{u, w});
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;

        long[] ways = new long[n];
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[1], b[1])
        );
        pq.offer(new long[]{0, 0});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int node = (int) cur[0];
            long d = cur[1];

            if (d > dist[node]) continue;

            for (long[] nei : graph.get(node)) {
                int next = (int) nei[0];
                long weight = nei[1];

                if (dist[next] > d + weight) {
                    dist[next] = d + weight;
                    ways[next] = ways[node];
                    pq.offer(new long[]{next, dist[next]});
                } else if (dist[next] == d + weight) {
                    ways[next] = (ways[next] + ways[node]) % MOD;
                }
            }
        }

        return (int)(ways[n - 1] % MOD);
    }
}