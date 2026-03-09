import java.util.*;
import java.io.*;

public class roundtrip {
    static List<Integer>[] adj;
    static boolean[] visited;
    static int[] parent;
    static List<Integer> cycle = null;

    static void dfs(int u, int par) {
        visited[u] = true;
        parent[u] = par;
        for (int v : adj[u]) {
            if (v == par) continue;
            if (visited[v]) {
                // cycle found
                if (cycle == null) {
                    cycle = new ArrayList<>();
                    cycle.add(v);
                    int current = u;
                    while (current != v) {
                        cycle.add(current);
                        current = parent[current];
                    }
                    cycle.add(v);
                }
            } else {
                dfs(v, u);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
        visited = new boolean[n + 1];
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i, -1);
                if (cycle != null) break;
            }
        }
        if (cycle != null) {
            System.out.println(cycle.size());
            for (int x : cycle) System.out.print(x + " ");
            System.out.println();
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}
