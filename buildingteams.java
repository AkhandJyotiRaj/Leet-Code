import java.util.ArrayList;
import java.util.*;

public class buildingteams {

    public static void main(String[] args) {
        
        ArrayList<Integer> team1 = new ArrayList<>();
        ArrayList<Integer> team2 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n+1);
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n+1];
        for(int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (!bipartiteCheck(adj, visited, team1, team2, i)) {
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        System.out.println(team1.size() + " " + team2.size());
        for (int i = 0; i < team1.size(); i++) {
            System.out.print(team1.get(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < team2.size(); i++) {
            System.out.print(team2.get(i) + " ");
        }
        System.out.println();

    }

    private static boolean bipartiteCheck(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> team1, ArrayList<Integer> team2, int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] color = new int[adj.size()];
        Arrays.fill(color, -1);
        q.add(start);
        visited[start] = true;
        color[start] = 0;
        team1.add(start);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj.get(u)) {
                if (color[v] == -1) {
                    color[v] = 1 - color[u];
                    visited[v] = true;
                    q.add(v);
                    if (color[v] == 0) team1.add(v);
                    else team2.add(v);
                } else if (color[v] == color[u]) {
                    return false;
                }
            }
        }
        return true;
    }
}
