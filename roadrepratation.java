import java.util.*;
import java.io.*;

public class roadrepratation {
    static class Edge implements Comparable<Edge> {
        int a, b, c;
        Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        public int compareTo(Edge other) {
            return Integer.compare(this.c, other.c);
        }
    }

    static int[] parent;
    static int[] rank;

    static void makeSet(int v) {
        parent[v] = v;
        rank[v] = 0;
    }

    static int findSet(int v) {
        if (v == parent[v]) return v;
        return parent[v] = findSet(parent[v]);
    }

    static void unionSets(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a != b) {
            if (rank[a] < rank[b]) {
                int temp = a;
                a = b;
                b = temp;
            }
            parent[b] = a;
            if (rank[a] == rank[b]) rank[a]++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, c));
        }
        Collections.sort(edges);

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            makeSet(i);
        }

        long totalCost = 0;
        int components = n;
        for (Edge e : edges) {
            if (findSet(e.a) != findSet(e.b)) {
                unionSets(e.a, e.b);
                totalCost += e.c;
                components--;
            }
        }

        if (components == 1) {
            System.out.println(totalCost);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
