public class Solution {
    private boolean rec(int r,int c,int m,int n,int ind,char[][] board, String word)
    {
        if(ind == word.length()) return true;
        if(r<0 || c<0 ||r>=m || c>=n || board[r][c]!=word.charAt(ind)) return false;
        char temp = board[r][c];
        board[r][c] = '#';
        boolean down = rec(r+1,c,m,n,ind+1,board,word);
        boolean up = rec(r-1,c,m,n,ind+1,board,word);
        boolean left = rec(r,c-1,m,n,ind+1,board,word);
        boolean right = rec(r,c+1,m,n,ind+1,board,word);
        board[r][c] = temp;
        return left || right || up || down;
    }
    public boolean exist(char[][] board, String word) {
        int m =board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j] == word.charAt(0))
                {
                    if(rec(i,j,m,n,0,board,word))
                     return true;
                }
            }
        }
        return false;
    }
} {
    
}
