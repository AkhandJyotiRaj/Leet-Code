class Solution {

    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int rowDirection[] = {1, -1, 0, 0};
    int colDirection[] = {0, 0, 1, -1};

    public boolean isValid(int x, int y, int n, int m) {
        if (x >= 0 && x < n && y >= 0 && y < m) return true;
        return false;
    }

    public void solve(char[][] board) {

        int n = board.length;
        int m = board[0].length;

        boolean[][] isVisited = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) 
                    && board[i][j] == 'O') {
                    
                    q.add(new Pair(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {

            Pair curr = q.poll();
            int currRow = curr.row;
            int currCol = curr.col;

            board[currRow][currCol] = 'T';  

            for (int k = 0; k < 4; k++) {
                int newRow = currRow + rowDirection[k];
                int newCol = currCol + colDirection[k];

                if (isValid(newRow, newCol, n, m) &&
                    board[newRow][newCol] == 'O' &&
                    !isVisited[newRow][newCol]) {

                    isVisited[newRow][newCol] = true;
                    q.add(new Pair(newRow, newCol));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O')
                    board[i][j] = 'X';

                if (board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }
    }
}
