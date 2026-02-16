import java.util.*;

public class Main {
    static class Node {
        int r, c;
        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[] dirChar = {'D', 'U', 'L', 'R'};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] grid = new char[n][m];
        int[][] monsterTime = new int[n][m];
        int[][] playerTime = new int[n][m];

        for (int[] row : monsterTime)
            Arrays.fill(row, Integer.MAX_VALUE);

        Queue<Node> monsterQueue = new LinkedList<>();
        Node start = null;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
                if (grid[i][j] == 'M') {
                    monsterQueue.add(new Node(i, j));
                    monsterTime[i][j] = 0;
                }
                if (grid[i][j] == 'A') {
                    start = new Node(i, j);
                }
            }
        }

        // Step 1: Multi-source BFS for monsters
        while (!monsterQueue.isEmpty()) {
            Node curr = monsterQueue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (grid[nr][nc] != '#' && monsterTime[nr][nc] == Integer.MAX_VALUE) {
                        monsterTime[nr][nc] = monsterTime[curr.r][curr.c] + 1;
                        monsterQueue.add(new Node(nr, nc));
                    }
                }
            }
        }

        // Step 2: BFS for player
        Queue<Node> playerQueue = new LinkedList<>();
        playerQueue.add(start);
        playerTime[start.r][start.c] = 0;

        Node[][] parent = new Node[n][m];
        char[][] move = new char[n][m];

        while (!playerQueue.isEmpty()) {
            Node curr = playerQueue.poll();

            // Check if boundary reached
            if (curr.r == 0 || curr.r == n - 1 || curr.c == 0 || curr.c == m - 1) {
                // Reconstruct path
                StringBuilder path = new StringBuilder();
                Node temp = curr;
                while (!(temp.r == start.r && temp.c == start.c)) {
                    path.append(move[temp.r][temp.c]);
                    temp = parent[temp.r][temp.c];
                }
                path.reverse();

                System.out.println("YES");
                System.out.println(path.length());
                System.out.println(path);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr.r + dr[d];
                int nc = curr.c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (grid[nr][nc] != '#' && playerTime[nr][nc] == 0 && !(nr == start.r && nc == start.c)) {
                        int nextTime = playerTime[curr.r][curr.c] + 1;

                        if (nextTime < monsterTime[nr][nc]) {
                            playerTime[nr][nc] = nextTime;
                            parent[nr][nc] = curr;
                            move[nr][nc] = dirChar[d];
                            playerQueue.add(new Node(nr, nc));
                        }
                    }
                }
            }
        }

        System.out.printl
