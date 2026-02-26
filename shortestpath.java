import java.util.*;

public class shortestpath {

    static class Edge {
        int to;
        long cost;
        Edge(int t, long c) {
            to = t;
            cost = c;
        }
    }

    static class State implements Comparable<State> {
        int node;
        int used;
        long dist;

        State(int node, int used, long dist) {
            this.node = node;
            this.used = used;
            this.dist = dist;
        }

        public int compareTo(State other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();
            graph[a].add(new Edge(b, c));
        }

        long[][] dist = new long[n + 1][2];
        for (int i = 1; i <= n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }

        PriorityQueue<State> pq = new PriorityQueue<>();
        dist[1][0] = 0;
        pq.add(new State(1, 0, 0));

        while (!pq.isEmpty()) {
            State curr = pq.poll();

            if (curr.dist > dist[curr.node][curr.used]) continue;

            for (Edge e : graph[curr.node]) {
                if (dist[e.to][curr.used] > curr.dist + e.cost) {
                    dist[e.to][curr.used] = curr.dist + e.cost;
                    pq.add(new State(e.to, curr.used, dist[e.to][curr.used]));
                }

                if (curr.used == 0) {
                    long discounted = curr.dist + e.cost / 2;
                    if (dist[e.to][1] > discounted) {
                        dist[e.to][1] = discounted;
                        pq.add(new State(e.to, 1, discounted));
                    }
                }
            }
        }

        System.out.println(Math.min(dist[n][0], dist[n][1]));
        sc.close();
    }
}