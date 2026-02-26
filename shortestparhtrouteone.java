import java.io.*;
import java.util.*;

public class shortestparhtrouteone {

    static class Edge {
        int to;
        long weight;

        Edge(int to, long weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static class Node implements Comparable<Node> {
        int city;
        long dist;

        Node(int city, long dist) {
            this.city = city;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return Long.compare(this.dist, other.dist);
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int nextInt() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(br.readLine());
        return Integer.parseInt(st.nextToken());
    }

    static long nextLong() throws IOException {
        while (st == null || !st.hasMoreElements())
            st = new StringTokenizer(br.readLine());
        return Long.parseLong(st.nextToken());
    }

    public static void main(String[] args) throws Exception {

        int n = nextInt();
        int m = nextInt();

        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = nextInt();
            int b = nextInt();
            long c = nextLong();
            graph[a].add(new Edge(b, c));
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.dist != dist[curr.city]) continue;

            for (Edge e : graph[curr.city]) {
                long newDist = curr.dist + e.weight;
                if (newDist < dist[e.to]) {
                    dist[e.to] = newDist;
                    pq.add(new Node(e.to, newDist));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dist[i]).append(" ");
        }

        System.out.println(sb);
    }
}