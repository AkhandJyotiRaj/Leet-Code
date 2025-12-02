class Solution {
    public static void solve(int row,int n,boolean[] hashd1,boolean[] hashd2,boolean[] hash,List<List<String>> list,char[][] board){
        if(row == n){
            list.add(buildBoard(board));
            return;
        }
        for(int col = 0;col < n;col++){
            int d1 = col + row;
            int d2 = row - col + n - 1;
            if(hashd1[d1]||hashd2[d2]||hash[col]) continue;
            board[row][col] = 'Q';
            hashd1[d1] = hashd2[d2] = hash[col] = true;
            solve(row + 1,n,hashd1,hashd2,hash,list,board);
            board[row][col] = '.';
            hashd1[d1] = hashd2[d2] = hash[col] = false;
        }
    }
    private static List<String> buildBoard(char[][] board){
        List<String> b = new ArrayList<>();
        for(char[] row : board) b.add(new String(row));
        return b;
    }
    public List<List<String>> solveNQueens(int n) {
        boolean hashd1[] = new boolean[n + n - 1];
        boolean hashd2[] = new boolean[n + n - 1];
        boolean hash[] = new boolean[n];
        char[][] board = new char[n][n];
        for(char[] row : board) Arrays.fill(row,'.');
        List<List<String>> list = new ArrayList<>();
        solve(0,n,hashd1,hashd2,hash,list,board);
        return list;
    }
}