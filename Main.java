import java.util.*;

public class Main {
    
    static int m, n;
    static int emptyCount = 1; 
    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read grid size
        System.out.print("Enter rows (m): ");
        m = sc.nextInt();
        
        System.out.print("Enter cols (n): ");
        n = sc.nextInt();

        int[][] grid = new int[m][n];

        System.out.println("Enter grid values (1, 2, 0, -1):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int answer = uniquePathsIII(grid);
        System.out.println("Number of unique paths = " + answer);
    }

    public static int uniquePathsIII(int[][] grid) {
        emptyCount = 1; // reset for each call
        result = 0;

        int startX = 0, startY = 0;

        // Count empty + start cells and locate the starting point
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) emptyCount++;
                else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        dfs(grid, startX, startY);
        return result;
    }

    private static void dfs(int[][] grid, int x, int y) {

        // Out of bounds or blocked
        if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] == -1)
            return;

        // If the end is reached
        if (grid[x][y] == 2) {
            if (emptyCount == 0) result++;  // Valid path only if all squares visited
            return;
        }

        // Mark this cell as visited
        grid[x][y] = -1;
        emptyCount--;

        // Explore 4 directions
        dfs(grid, x + 1, y);
        dfs(grid, x - 1, y);
        dfs(grid, x, y + 1);
        dfs(grid, x, y - 1);

        // Backtrack
        grid[x][y] = 0;
        emptyCount++;
    }
}
