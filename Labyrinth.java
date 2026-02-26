import java.util.*;

public class Labyrinth {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];
        int startI = -1, startJ = -1, endI = -1, endJ = -1;
        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < m; j++) {
                grid[i][j] = row.charAt(j);
                if (grid[i][j] == 'A') {
                    startI = i;
                    startJ = j;
                } else if (grid[i][j] == 'B') {
                    endI = i;
                    endJ = j;
                }
            }
        }

        String result = shortestPath(grid, startI, startJ, endI, endJ);
        System.out.println(result);
    }

    privategit static String shortestPath(char[][] grid, int startI, int startJ, int endI, int endJ) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] prevI = new int[n][m];
        int[][] prevJ = new int[n][m];
        String[][] prevDir = new String[n][m];
        
        int[] di = {-1, 0, 1, 0};
        int[] dj = {0, 1, 0, -1};
        String[] dirs = {"U", "R", "D", "L"};
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startI, startJ});
        visited[startI][startJ] = true;
        prevI[startI][startJ] = -1;
        prevJ[startI][startJ] = -1;
        prevDir[startI][startJ] = "";
        
        boolean found = false;
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];
            if (i == endI && j == endJ) {
                found = true;
                break;
            }
            for (int k = 0; k < 4; k++) {
                int ni = i + di[k];
                int nj = j + dj[k];
                if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj] && grid[ni][nj] != '#') {
                    visited[ni][nj] = true;
                    prevI[ni][nj] = i;
                    prevJ[ni][nj] = j;
                    prevDir[ni][nj] = dirs[k];
                    q.add(new int[]{ni, nj});
                }
            }
        }
        
        if (!found) {
            return "NO";
        }
        
        // Reconstruct path
        StringBuilder path = new StringBuilder();
        int ci = endI, cj = endJ;
        while (ci != -1) {
            path.append(prevDir[ci][cj]);
            int pi = prevI[ci][cj];
            int pj = prevJ[ci][cj];
            ci = pi;
            cj = pj;
        }
        path.reverse();
        // Remove the empty start
        if (path.length() > 0) path.deleteCharAt(0);
        
        return "YES\n" + path.length() + "\n" + path.toString();
    }
}
