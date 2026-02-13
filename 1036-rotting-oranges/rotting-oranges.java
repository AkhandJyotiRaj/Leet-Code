class Solution {

    class Cell {
        int row;
        int col;
        public Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private int n;
    private int m;

    private static int[][] directions = {
        {-1, 0},
        {0, 1},
        {1, 0},
        {0, -1}
    };

    private boolean isInsideGrid(int i, int j) {
        return (i >= 0 && i < n && j >= 0 && j < m);
    }

    public int orangesRotting(int[][] grid) {
        n = grid.length;
        m = grid[0].length;

        Queue<Cell> queue = new LinkedList<>();
        int[][] timer = new int[n][m];
        boolean[][] rotten = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Cell(i, j));
                    rotten[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            for (int dir = 0; dir < 4; dir++) {
                int row = curr.row + directions[dir][0];
                int col = curr.col + directions[dir][1];

                if (isInsideGrid(row, col) && !rotten[row][col] && grid[row][col] == 1) {
                    rotten[row][col] = true;
                    timer[row][col] = 1 + timer[curr.row][curr.col];
                    queue.add(new Cell(row, col));
                }
            }
        }

        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !rotten[i][j])
                    return -1;
                res = Math.max(res, timer[i][j]);
            }
        }

        return res;
    }
}