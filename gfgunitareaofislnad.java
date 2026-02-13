public import java.util.*;

class Solution {
    
    class Pair {
        int row;
        int col;
        
        Pair(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    // Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] visited = new boolean[n][m];
        int maxArea = 0;
        
        // 8 directions
        int[] dRow = {-1,-1,-1,0,0,1,1,1};
        int[] dCol = {-1,0,1,-1,1,-1,0,1};
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                
                if(grid[i][j] == 1 && !visited[i][j]) {
                    int area = bfs(grid, visited, i, j, dRow, dCol);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        
        return maxArea;
    }
    
    private int bfs(int[][] grid, boolean[][] visited, int row, int col,
                    int[] dRow, int[] dCol) {
        
        int n = grid.length;
        int m = grid[0].length;
        
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        
        int area = 0;
        
        while(!queue.isEmpty()) {
            Pair curr = queue.poll();
            area++;
            
            for(int k = 0; k < 8; k++) {
                int newRow = curr.row + dRow[k];
                int newCol = curr.col + dCol[k];
                
                if(newRow >= 0 && newRow < n &&
                   newCol >= 0 && newCol < m &&
                   grid[newRow][newCol] == 1 &&
                   !visited[newRow][newCol]) {
                    
                    visited[newRow][newCol] = true;
                    queue.add(new Pair(newRow, newCol));
                }
            }
        }
        
        return area;
    }
}
 gfgunitareaofislnad {
    
}
